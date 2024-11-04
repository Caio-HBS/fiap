package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Investimento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Servlet responsável por gerenciar as operações de consulta, atualização e remoção de investimentos do usuário.
 * <p>
 * Esta classe lida com requisições HTTP para consultar detalhes de um investimento, atualizá-lo ou excluí-lo.
 * Utiliza o <code>InvestimentoDAO</code> para interagir com o banco de dados e processar os dados do investimento
 * antes de redirecionar para a visualização adequada.
 * </p>
 *
 * <p>URL do servlet: <code>/investimento</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Obtém as informações de um investimento específico para exibição na página <code>atualizar-investimento.jsp</code>.</li>
 *     <li><strong>POST</strong>:
 *         <ul>
 *             <li><code>atualizar</code>: Atualiza os dados do investimento com base nos valores recebidos do formulário.</li>
 *             <li><code>deletar</code>: Remove o investimento do banco de dados.</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <p>Parâmetros:</p>
 * <ul>
 *     <li><code>id</code>: Identificador do investimento.</li>
 *     <li><code>acao</code>: Determina a ação a ser realizada (<code>atualizar</code> ou <code>deletar</code>).</li>
 *     <li><code>nome-investimento</code>, <code>desc-investimento</code>, <code>data-inicio-investimento</code>, <code>data-termino-investimento</code>,
 *     <code>valor-investimento</code>, <code>percent-mensal</code>: Dados usados ao atualizar o investimento.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>DBException</code>: Captura erros de banco de dados e exibe uma mensagem de erro ao usuário.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see InvestimentoDAO
 */
@WebServlet("/investimento")
public class InvestimentoServlet extends HttpServlet {

    private InvestimentoDAO investimentoDAO;

    @Override
    public void init() {
        investimentoDAO = DAOFactory.getInvestimentoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int idInvestimento = Integer.parseInt(req.getParameter("id"));

        Investimento inv = investimentoDAO.buscarPorId(idInvestimento);

        if (inv != null) {
            inv.setValorInicial((int) inv.getValorInicial());
            session.setAttribute("inv", inv);
        }

        req.getRequestDispatcher("atualizar-investimento.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int idInvestimento = Integer.parseInt(req.getParameter("id"));
        int idUsuario = (Integer) session.getAttribute("userId");
        String acao = req.getParameter("acao");

        switch (acao) {
            case "atualizar":
                LocalDate dtTermino;
                String nmInvestimento = req.getParameter("nome-investimento");
                String descInvestimento = req.getParameter("desc-investimento");
                LocalDate dtInicio = Date.valueOf(req.getParameter("data-inicio-investimento")).toLocalDate();
                try {
                    dtTermino = Date.valueOf(req.getParameter("data-termino-investimento")).toLocalDate();
                } catch (Exception e) {
                    dtTermino = null;
                }
                double valorInvestimento = Double.parseDouble(req.getParameter("valor-investimento"));
                int percentMensal = Integer.parseInt(req.getParameter("percent-mensal"));

                Investimento invAtualizado = new Investimento(
                        idInvestimento, idUsuario, nmInvestimento, descInvestimento,
                        dtInicio, dtTermino, valorInvestimento, percentMensal
                );

                try {
                    investimentoDAO.atualizar(invAtualizado);

                    resp.sendRedirect(req.getContextPath() + "/investimentos");
                } catch (DBException e) {
                    req.setAttribute("erro", e.getMessage());
                    req.getRequestDispatcher("atualizar-investimento.jsp").forward(req, resp);
                }
                break;

            case "deletar":
                try {
                    investimentoDAO.remover(idInvestimento, idUsuario);

                    resp.sendRedirect(req.getContextPath() + "/investimentos");
                } catch (DBException e) {
                    req.setAttribute("erro", e.getMessage());
                    req.getRequestDispatcher("atualizar-investimento.jsp").forward(req, resp);
                }
                break;

            default:
                req.setAttribute("erro", "Erro inesperado. Entre em contato com o administrador.");
                req.getRequestDispatcher("atualizar-investimento.jsp").forward(req, resp);
        }

    }

}
