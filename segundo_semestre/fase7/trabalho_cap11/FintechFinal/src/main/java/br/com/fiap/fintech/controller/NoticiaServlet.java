package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.NoticiaDAO;
import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Noticia;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/noticia")
public class NoticiaServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;
    private NoticiaDAO noticiaDAO;

    @Override
    public void init() {
        usuarioDAO = DAOFactory.getUsuarioDAO();
        noticiaDAO = DAOFactory.getNoticiaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int idNoticia = Integer.parseInt(req.getParameter("id_noticia"));

            Noticia noticia = noticiaDAO.buscarPorId(idNoticia);
            req.setAttribute("noticia", noticia);

            Usuario autor = usuarioDAO.buscarPorId(noticia.getIdUsuario());
            req.setAttribute("autor", autor);

            req.getRequestDispatcher("noticia.jsp").forward(req, resp);

        } catch (NumberFormatException e) {
            req.getRequestDispatcher("404.jsp").forward(req, resp);
        }

    }

}
