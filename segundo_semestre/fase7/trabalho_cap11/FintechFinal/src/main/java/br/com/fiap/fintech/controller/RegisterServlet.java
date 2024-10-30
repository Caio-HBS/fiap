package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.UsuarioInfoDAO;
import br.com.fiap.fintech.exception.DBException;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.UsuarioInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;
    private UsuarioInfoDAO infoDAO;

    @Override
    public void init() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
        infoDAO = DAOFactory.getUsuarioInfoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            resp.sendRedirect(req.getContextPath() + "/dashboard");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario checagemUsuario = usuarioDAO.buscarPorEmail(req.getParameter("email-registro"));

        if (checagemUsuario != null) {
            req.setAttribute("erro", "E-mail já cadastrado.");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        } else {
            String nome = req.getParameter("nome-registro");
            String sobrenome = req.getParameter("sobrenome-registro");
            String email = req.getParameter("email-registro");
            String nmUsuario = req.getParameter("nome-usuario-registro");
            LocalDate dtNascimento = LocalDate.parse(req.getParameter("dt-nascimento-registro"));
            char novidades = !Objects.equals(req.getParameter("novidades-registro"), "true") ? 'N' : 'Y';
            String senha = req.getParameter("senha-registro");
            String pronomes = req.getParameter("pronomes-registro");
            String apelido = req.getParameter("apelido-registro");

            try {
                // Criar usuário.
                Usuario novoUsuario = new Usuario(nome, sobrenome, dtNascimento, email, nmUsuario, senha, "USER");
                usuarioDAO.cadastrar(novoUsuario);

                // Recuperar usuário recém-criado.
                novoUsuario = usuarioDAO.buscarPorEmail(email);

                // Criar informações adicionais de usuário.
                UsuarioInfo usuarioInfo = new UsuarioInfo(
                        novoUsuario.getIdUsuario(), LocalDate.now(), 'N', novidades, pronomes, apelido
                );
                infoDAO.cadastrar(usuarioInfo);

                req.setAttribute("success", "Fa&ccedil;a login para utilizar a plataforma.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } catch (DBException e) {
                req.setAttribute("erro", e.getMessage());
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        }

    }

}
