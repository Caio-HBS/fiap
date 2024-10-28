package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.util.CriptografiaUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email-login");
        String senha = req.getParameter("senha-login");

        Usuario usuario = usuarioDAO.validarUsuario(email, senha);

        if (usuario != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            session.setAttribute("userId", usuario.getIdUsuario());

            resp.sendRedirect(req.getContextPath() + "/dashboard");
        } else {
            req.setAttribute("erro", "Usuário e/ou senha inválidos.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
