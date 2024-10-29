package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.DashboardInfoDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.DashboardInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    private DashboardInfoDAO dashboardDAO;

    @Override
    public void init() {
        dashboardDAO = DAOFactory.getDashboardInfoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        DashboardInfo info = dashboardDAO.buscarDashboardInfo((Integer) session.getAttribute("userId"));

        if (info != null) {
            req.setAttribute("info", info);
            // Checa se há algum investimento antes de chamar a função.
            if (info.getValorUltimoInvestimento() != 0.0) {
                double rend = calcularRendimento(info);
                req.setAttribute("rend", rend);
            }
        }

        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }

    private double calcularRendimento(DashboardInfo info) {
        LocalDate inicioInv = info.getDtInicioUltimoInvestimento();
        LocalDate hoje = LocalDate.now();

        Period period = Period.between(inicioInv, hoje);
        int difMeses = period.getYears() * 12 + period.getMonths();

        return info.getValorUltimoInvestimento() * Math.pow(1 + ((double) info.getPercentUltimoInvestimento() / 100),
                difMeses);
    }

}
