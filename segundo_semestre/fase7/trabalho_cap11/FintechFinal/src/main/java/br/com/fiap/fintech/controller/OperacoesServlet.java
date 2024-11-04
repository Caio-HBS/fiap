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
import java.util.List;
import java.util.Objects;

/**
 * Servlet responsável pela listagem e criação de novas operações financeiras.
 * <p>
 * Esta classe permite que o usuário visualize uma lista completa de operações e adicione novas operações
 * ao seu histórico financeiro. Utiliza o <code>OperacaoDAO</code> para realizar operações de listagem e cadastro no
 * banco de dados.
 * </p>
 *
 * <p>URL do servlet: <code>/operacoes</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Recupera e exibe todas as operações financeiras associadas ao usuário atual,
 *     encaminhando o usuário para a página <code>operacoes.jsp</code> com a lista de operações carregada.</li>
 *     <li><strong>POST</strong>: Processa o cadastro de uma nova operação financeira. Os dados da nova operação
 *     são recebidos e validados, e em seguida a operação é persistida no banco de dados.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>DBException</code>: Captura falhas ao cadastrar uma nova operação no banco de dados, exibe uma
 *     mensagem de erro e mantém o usuário na página de cadastro.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see OperacaoDAO
 */
@WebServlet("/operacoes")
public class OperacoesServlet extends HttpServlet {

    private OperacaoDAO operacaoDAO;

    @Override
    public void init() {
        operacaoDAO = DAOFactory.getOperacaoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<Operacao> operacoes = operacaoDAO.listar((Integer) session.getAttribute("userId"));

        if (operacoes != null) {
            req.setAttribute("operacoes", operacoes);
        }
        req.getRequestDispatcher("operacoes.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String nmOperacao = req.getParameter("nome-operacao");
        String descOperacao = req.getParameter("desc-operacao");
        char tipoOperacao = Objects.equals(req.getParameter("tipo-operacao"), "R") ? 'R' : 'D';
        LocalDate dataOperacao = Date.valueOf(req.getParameter("data-operacao")).toLocalDate();
        double valorOperacao = Double.parseDouble(req.getParameter("valor-operacao"));

        try {
            Operacao novaOp = new Operacao(
                    (Integer) session.getAttribute("userId"), nmOperacao, descOperacao, LocalDate.now(),
                    dataOperacao, valorOperacao, tipoOperacao
            );
            operacaoDAO.cadastrar(novaOp);

            resp.sendRedirect(req.getContextPath() + "/operacoes");
        } catch (DBException e) {
            req.setAttribute("erro", e.getMessage());
            req.getRequestDispatcher("operacoes.jsp").forward(req, resp);
        }

    }
}
