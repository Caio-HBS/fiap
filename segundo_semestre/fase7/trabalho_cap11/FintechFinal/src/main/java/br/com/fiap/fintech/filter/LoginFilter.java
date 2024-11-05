package br.com.fiap.fintech.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Filtro para controle de acesso de usuários autenticados no aplicativo.
 * <p>
 * Este filtro intercepta todas as requisições para verificar se o usuário está autenticado
 * antes de acessar qualquer recurso protegido. Se o usuário não estiver autenticado, ele é
 * redirecionado para a página de login (<code>login.jsp</code>).
 * </p>
 *
 * <p>URL do filtro: <code>/*</code> (toda a aplicação).</p>
 *
 * <p>Funcionalidades:</p>
 * <ul>
 *     <li>Redireciona usuários não autenticados para a página de login ao tentar acessar
 *     recursos que não sejam <code>index.jsp</code>, <code>login</code>, <code>register</code>,
 *     <code>resources</code> ou <code>noticia</code>.</li>
 *     <li>Redireciona usuários autenticados que tentam acessar a URL da raiz (<code>/fintech/</code>)
 *     diretamente para o <code>dashboard</code>.</li>
 *     <li>Permite o acesso à solicitação se o usuário já estiver autenticado ou se a
 *     URL solicitada estiver entre as exceções mencionadas acima.</li>
 * </ul>
 *
 * <p>Parâmetros e Atributos:</p>
 * <ul>
 *     <li><code>session.getAttribute("user")</code>: Identifica se o usuário está autenticado.</li>
 *     <li><code>req.getRequestURI()</code>: Obtém a URL da requisição para verificar a rota solicitada.</li>
 * </ul>
 *
 * <p>Exceções Tratadas:</p>
 * <ul>
 *     <li><code>ServletException</code>: Pode ser lançada ao encaminhar a requisição
 *     para o login se o usuário não estiver autenticado.</li>
 *     <li><code>IOException</code>: Pode ser lançada durante a execução do filtro.</li>
 * </ul>
 *
 * @see Filter
 * @see HttpSession
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();

        if (
                session.getAttribute("user") == null && !url.endsWith("/") && !url.endsWith("index.jsp")
                && !url.contains("login") && !url.contains("register") && !url.contains("resources")
                && !url.contains("noticia")
        ) {
            servletRequest.setAttribute("erro", "Entre na sua conta para utilizar o aplicativo.");
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        } else if (session.getAttribute("user") != null && url.endsWith(("fintech/"))) {
            res.sendRedirect(req.getContextPath() + "/dashboard");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

}
