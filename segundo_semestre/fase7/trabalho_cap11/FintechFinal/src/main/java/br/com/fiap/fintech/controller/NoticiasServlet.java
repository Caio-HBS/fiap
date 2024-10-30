package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.NoticiaDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Noticia;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/noticias")
public class NoticiasServlet extends HttpServlet {

    private NoticiaDAO noticiaDAO;

    @Override
    public void init() {
        noticiaDAO = DAOFactory.getNoticiaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Noticia> noticias = noticiaDAO.listar();

        req.setAttribute("noticias", noticias);
        req.getRequestDispatcher("noticias.jsp").forward(req, resp);

    }
}
