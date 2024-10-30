package br.com.fiap.fintech.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
                && !url.contains("login") && !url.endsWith("register.jsp") && !url.contains("resources")
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
