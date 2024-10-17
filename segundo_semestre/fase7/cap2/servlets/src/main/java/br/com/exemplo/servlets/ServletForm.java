package br.com.exemplo.servlets;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/exemplo")
public class ServletForm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("user");
        String senha = request.getParameter("pass");

        if (login.equals("user") && senha.equals("123")) {
            response.sendRedirect("success.html");
        } else {
            response.sendRedirect("access_denied.html");
        }
    }

}