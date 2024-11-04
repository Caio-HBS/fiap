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

/**
 * Servlet responsável por exibir o conteúdo de uma notícia específica e suas informações de autor.
 * <p>
 * Esta classe processa requisições para carregar os detalhes de uma notícia, identificada pelo seu ID, e exibe as
 * informações da notícia e do autor associado na página de visualização.
 * Utiliza o <code>NoticiaDAO</code> para obter o conteúdo da notícia e o <code>UsuarioDAO</code> para buscar
 * informações do autor.
 * </p>
 *
 * <p>URL do servlet: <code>/noticia</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Carrega uma notícia específica e as informações do autor,
 *     encaminhando o usuário para a página <code>noticia.jsp</code> com os dados carregados.
 *     Se o ID da notícia for inválido, redireciona para a página de erro <code>404.jsp</code>.</li>
 * </ul>
 *
 * <p>Parâmetros:</p>
 * <ul>
 *     <li><code>id_noticia</code>: Identificador único da notícia a ser carregada.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>NumberFormatException</code>: Caso o parâmetro <code>id_noticia</code> seja inválido,
 *     redireciona o usuário para a página <code>404.jsp</code>.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see NoticiaDAO
 * @see UsuarioDAO
 */
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
