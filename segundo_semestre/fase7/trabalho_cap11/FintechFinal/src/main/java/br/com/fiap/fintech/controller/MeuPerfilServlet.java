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

/**
 * Servlet para visualização, atualização e exclusão do perfil de usuário.
 * <p>
 * Este servlet gerencia as operações relacionadas ao perfil do usuário, incluindo: visualização dos dados pessoais,
 * atualização das informações e exclusão da conta.
 * As operações são definidas de acordo com o parâmetro "acao" recebido no request.
 * </p>
 *
 * <p>Exemplo de Uso:</p>
 * <pre>
 *     - GET: Carrega as informações do usuário e exibe a página de perfil.
 *     - POST (acao="atualizar"): Atualiza o perfil do usuário com as novas informações fornecidas.
 *     - POST (acao="deletar"): Exclui o perfil do usuário e redireciona para a página inicial.
 * </pre>
 *
 * <p>Exceções:</p>
 * <ul>
 *     <li><code>DBException</code>: Lançada quando ocorre um erro ao acessar ou atualizar o banco de dados.</li>
 *     <li><code>ServletException</code>: Lançada quando a ação fornecida não é reconhecida.</li>
 * </ul>
 *
 * <p>Retorno:</p>
 * <ul>
 *     <li>Redireciona para a página de perfil em caso de sucesso na atualização.</li>
 *     <li>Redireciona para a página inicial ao excluir a conta.</li>
 *     <li>Carrega mensagens de erro na página de perfil se ocorrer uma falha.</li>
 * </ul>
 *
 * @see HttpServlet
 */
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
        String acao = req.getParameter("acao");
        int userId = (Integer) session.getAttribute("userId");

        switch (acao) {
            case "atualizar":

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
                break;
            case "deletar":
                try {
                    usuarioDAO.remover(userId);

                    session.invalidate();
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } catch (DBException e) {
                    req.setAttribute("erro", e.getMessage());
                    req.getRequestDispatcher("meu-perfil.jsp").forward(req, resp);
                }
                break;
            default:
                throw new ServletException("Erro ao atualizar o registro.");
        }

    }

}
