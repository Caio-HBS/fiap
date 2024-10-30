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
                System.out.println(opAtualizada);
                try {
                    operacaoDAO.atualizar(opAtualizada);
                    System.out.println("Foi atualizado");
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
