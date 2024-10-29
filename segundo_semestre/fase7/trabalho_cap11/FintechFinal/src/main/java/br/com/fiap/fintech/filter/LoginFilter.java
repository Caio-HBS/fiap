package br.com.fiap.fintech.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String url = req.getRequestURI();

        if (
                session.getAttribute("user") == null && !url.endsWith("/") && !url.endsWith("index.jsp")
                && !url.contains("login") && !url.endsWith("register.jsp") && !url.contains("resources") && !url.endsWith("noticias.jsp")
        ) {
            servletRequest.setAttribute("erro", "Entre na sua conta para utilizar o aplicativo.");
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

}
