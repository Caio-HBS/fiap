package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Investimento;
import br.com.fiap.fintech.util.InvestimentoUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet responsável por listar e cadastrar investimentos do usuário.
 * <p>
 * Este servlet processa requisições para exibir a lista de investimentos cadastrados pelo usuário e para adicionar novos
 * investimentos. Utiliza o <code>InvestimentoDAO</code>  para interagir com o banco de dados, exibindo os investimentos
 * existentes e calculando o rendimento estimado de cada um.
 * </p>
 *
 * <p>URL do servlet: <code>/investimentos</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Recupera e exibe a lista de investimentos do usuário na página <code>investimentos.jsp</code>,
 *     incluindo os rendimentos estimados.</li>
 *     <li><strong>POST</strong>: Cadastra um novo investimento para o usuário e redireciona para a página de listagem.</li>
 * </ul>
 *
 * <p>Parâmetros:</p>
 * <ul>
 *     <li><code>nome-investimento</code>, <code>desc-investimento</code>, <code>data-inicio-investimento</code>,
 *     <code>valor-investimento</code>, <code>percent-mensal</code>: Dados para cadastro de um novo investimento.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>DBException</code>: Captura erros de banco de dados e exibe uma mensagem de erro ao usuário, mantendo-o na mesma página.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see InvestimentoDAO
 * @see InvestimentoUtils
 */
@WebServlet("/investimentos")
public class InvestimentosServlet extends HttpServlet {

    private InvestimentoDAO investimentoDAO;

    @Override
    public void init() {
        investimentoDAO = DAOFactory.getInvestimentoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<Investimento> investimentos = investimentoDAO.listar((Integer) session.getAttribute("userId"));
        List<String> rends = new ArrayList<>();

        if (investimentos != null) {
            req.setAttribute("investimentos", investimentos);

            for (Investimento inv : investimentos) {
                String rend = InvestimentoUtils.calcularRendimento(
                        inv.getValorInicial(), inv.getPercentMensal(), inv.getDataInicio()
                );
                rends.add(rend);
            }
            req.setAttribute("rendimentos", rends);
        }
        req.getRequestDispatcher("investimentos.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nmInvestimento = req.getParameter("nome-investimento");
        String descInvestimento = req.getParameter("desc-investimento");
        LocalDate dtInicio = Date.valueOf(req.getParameter("data-inicio-investimento")).toLocalDate();
        double valorInvestimento = Double.parseDouble(req.getParameter("valor-investimento"));
        int percentMensal = Integer.parseInt(req.getParameter("percent-mensal"));

        try {

            Investimento inv = new Investimento(
                    (Integer) session.getAttribute("userId"), nmInvestimento, descInvestimento, dtInicio,
                    null, valorInvestimento, percentMensal
            );
            investimentoDAO.cadastrar(inv);

            resp.sendRedirect(req.getContextPath() + "/investimentos");

        } catch (DBException e) {
            req.setAttribute("erro", e.getMessage());
            req.getRequestDispatcher("investimentos.jsp").forward(req, resp);
        }

    }

}
