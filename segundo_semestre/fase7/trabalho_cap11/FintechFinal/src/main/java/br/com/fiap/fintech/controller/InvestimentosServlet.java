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
import java.util.List;

@WebServlet("/investimentos")
public class InvestimentosServlet  extends HttpServlet {

    private InvestimentoDAO investimentoDAO;

    @Override
    public void init() {
        investimentoDAO = DAOFactory.getInvestimentoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        List<Investimento> investimentos = investimentoDAO.listar((Integer) session.getAttribute("userId"));

        if (investimentos != null) {
            req.setAttribute("investimentos", investimentos);
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
