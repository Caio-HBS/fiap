package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.DashboardInfoDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.DashboardInfo;
import br.com.fiap.fintech.util.InvestimentoUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
                String rend = InvestimentoUtils.calcularRendimento(
                        info.getValorUltimoInvestimento(), info.getPercentUltimoInvestimento(),
                        info.getDtInicioUltimoInvestimento()
                );
                req.setAttribute("rend", rend);
            }
        }
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);

    }

}
