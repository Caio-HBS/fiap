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
        System.out.println(session.getAttribute("userId"));

        DashboardInfo info = dashboardDAO.buscarDashboardInfo((Integer) session.getAttribute("userId"));

        if (info != null) {
            session.setAttribute("info", info);
        }
        System.out.println(info);
        req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
    }
}
