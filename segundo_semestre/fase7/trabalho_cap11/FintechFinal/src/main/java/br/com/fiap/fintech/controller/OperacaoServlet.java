package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.OperacaoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Operacao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Servlet responsável por exibir, atualizar e excluir operações financeiras do usuário.
 * <p>
 * Esta classe permite que o usuário visualize detalhes de uma operação específica, atualize suas informações,
 * ou exclua a operação. Utiliza o <code>OperacaoDAO</code> para gerenciar as operações no banco de dados.
 * </p>
 *
 * <p>URL do servlet: <code>/operacao</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Carrega uma operação específica para visualização e atualização,
 *     encaminhando o usuário para a página <code>atualizar-operacao.jsp</code> com os dados da operação.</li>
 *     <li><strong>POST</strong>: Processa ações de atualização ou exclusão de uma operação. Se o usuário
 *     optar por atualizar, os novos dados são validados e salvos. Se optar por excluir, a operação é removida.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>DBException</code>: Captura falhas de banco de dados ao atualizar ou excluir a operação, exibindo uma
 *     mensagem de erro e mantendo o usuário na página de edição.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see OperacaoDAO
 */
@WebServlet("/operacao")
public class OperacaoServlet extends HttpServlet {

    private OperacaoDAO operacaoDAO;

    @Override
    public void init() {
        operacaoDAO = DAOFactory.getOperacaoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int idOperacao = Integer.parseInt(req.getParameter("id"));

        Operacao op = operacaoDAO.buscarPorId(idOperacao);

        if (op != null) {
            op.setValorOperacao((int) op.getValorOperacao());
            session.setAttribute("op", op);
        }
        req.getRequestDispatcher("atualizar-operacao.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int idOperacao = Integer.parseInt(req.getParameter("id"));
        int idUsuario = (Integer) session.getAttribute("userId");
        String acao = req.getParameter("acao");

        switch (acao) {
            case "atualizar":
                String nmOperacao = req.getParameter("nome-operacao");
                String descOperacao = req.getParameter("desc-operacao");
                char tipoOperacao = Objects.equals(req.getParameter("tipo-operacao"), "R") ? 'R' : 'D';
                LocalDate dataOperacao = Date.valueOf(req.getParameter("data-operacao")).toLocalDate();
                double valorOperacao = Double.parseDouble(req.getParameter("valor-operacao"));

                Operacao opAtualizada = new Operacao(
                        idOperacao, idUsuario, nmOperacao, descOperacao, LocalDate.now(), dataOperacao, valorOperacao,
                        tipoOperacao
                );

                try {
                    operacaoDAO.atualizar(opAtualizada);

                    resp.sendRedirect(req.getContextPath() + "/operacoes");
                } catch (DBException e) {
                    req.setAttribute("erro", e.getMessage());
                    req.getRequestDispatcher("atualizar-operacao.jsp").forward(req, resp);
                }
                break;

            case "deletar":
                try {
                    operacaoDAO.remover(idOperacao, idUsuario);

                    resp.sendRedirect(req.getContextPath() + "/operacoes");
                } catch (DBException e) {
                    req.setAttribute("erro", e.getMessage());
                    req.getRequestDispatcher("atualizar-operacao.jsp").forward(req, resp);
                }
                break;

            default:
                req.setAttribute("erro", "Erro inesperado. Entre em contato com o administrador.");
                req.getRequestDispatcher("atualizar-operacao.jsp").forward(req, resp);
        }

    }

}
