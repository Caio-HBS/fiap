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
