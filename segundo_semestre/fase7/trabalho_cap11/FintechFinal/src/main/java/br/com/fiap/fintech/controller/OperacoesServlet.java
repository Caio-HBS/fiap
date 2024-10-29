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
        char tipoOperacao = Objects.equals(req.getParameter("tipo-operacao"), "R") ? 'R' : 'S';
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
