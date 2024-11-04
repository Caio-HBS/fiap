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

/**
 * Servlet responsável por exibir a lista de notícias.
 * <p>
 * Esta classe processa requisições para carregar uma lista completa de notícias e encaminha o usuário
 * para a página de listagem de notícias com os dados carregados.
 * Utiliza o <code>NoticiaDAO</code> para recuperar todas as notícias armazenadas.
 * </p>
 *
 * <p>URL do servlet: <code>/noticias</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Recupera a lista completa de notícias e redireciona para a página <code>noticias.jsp</code>
 *     com os dados carregados.</li>
 * </ul>
 *
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li>Se ocorrer uma falha no carregamento da lista, o servlet lida com a exceção padrão do Java Servlet.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see NoticiaDAO
 */
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
