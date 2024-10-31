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
import java.util.Map;
import java.util.Objects;

@WebServlet("/meu-perfil")
public class MeuPerfilServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;
    private UsuarioInfoDAO usuarioInfoDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = DAOFactory.getUsuarioDAO();
        usuarioInfoDAO = DAOFactory.getUsuarioInfoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userId = (Integer) session.getAttribute("userId");

        Map<Usuario, UsuarioInfo> map = usuarioDAO.buscarCompletoPorId(userId);
        Map.Entry<Usuario, UsuarioInfo> entry = map.entrySet().iterator().next();

        req.setAttribute("usuario", entry.getKey());
        req.setAttribute("info", entry.getValue());
        req.getRequestDispatcher("meu-perfil.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        int userId = (Integer) session.getAttribute("userId");

        UsuarioInfo infoVelha = usuarioInfoDAO.buscarPorIdUsuario(userId);

        String nome = req.getParameter("nome-novo");
        String sobrenome = req.getParameter("sobrenome-novo");
        String email = req.getParameter("email-novo");
        String nmUsuario = req.getParameter("nome-usuario-novo");
        LocalDate dtNascimento = LocalDate.parse(req.getParameter("dt-nascimento-novo"));
        char novidades = !Objects.equals(req.getParameter("novidades-novo"), "true") ? 'N' : 'Y';
        String senha = req.getParameter("senha-registro");
        String pronomes = req.getParameter("pronomes-novo");
        String apelido = req.getParameter("apelido-novo");

        Usuario usuarioAtualizado = new Usuario(
                userId, nome, sobrenome, dtNascimento, email, nmUsuario, senha, "USER"
        );

        UsuarioInfo infoAtualizada = new UsuarioInfo(
                userId, infoVelha.getDataRegistro(), 'N', novidades, pronomes, apelido
        );

        try {
            usuarioDAO.atualizar(usuarioAtualizado);
            usuarioInfoDAO.atualizar(infoAtualizada);

            resp.sendRedirect(req.getContextPath() + "/meu-perfil");
        } catch (DBException e) {
            req.setAttribute("erro", e.getMessage());
            req.getRequestDispatcher("meu-perfil.jsp").forward(req, resp);
        }

    }


}
