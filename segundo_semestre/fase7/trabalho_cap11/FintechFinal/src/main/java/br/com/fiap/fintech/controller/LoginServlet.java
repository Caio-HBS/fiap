package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.factory.DAOFactory;
import br.com.fiap.fintech.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet responsável pelo processo de login e logout do usuário.
 * <p>
 * Esta classe processa as requisições de login, validando as credenciais do usuário e iniciando uma sessão em caso de sucesso.
 * Se as credenciais estiverem incorretas, retorna uma mensagem de erro. Também gerencia o logout, invalidando a sessão.
 * </p>
 *
 * <p>URL do servlet: <code>/login</code></p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li><strong>GET</strong>: Realiza o logout do usuário ao invalidar a sessão e redireciona para a página <code>index.jsp</code>.</li>
 *     <li><strong>POST</strong>: Processa o login com as credenciais fornecidas. Se válidas, cria uma sessão e redireciona para a página de dashboard.
 *     Se inválidas, exibe uma mensagem de erro na página de login.</li>
 * </ul>
 *
 * <p>Parâmetros:</p>
 * <ul>
 *     <li><code>email-login</code>: E-mail do usuário.</li>
 *     <li><code>senha-login</code>: Senha do usuário.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>DBException</code>: Erros de banco de dados são tratados de forma geral no fluxo do servlet.</li>
 * </ul>
 *
 * @see HttpServlet
 * @see UsuarioDAO
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // adminFintech
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
            session.setAttribute("cargo", usuario.getCargo());

            resp.sendRedirect(req.getContextPath() + "/dashboard");
        } else {
            req.setAttribute("erro", "Usuário e/ou senha inválidos.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
