package com.supinfo.servlets;

import com.supinfo.Dto.UserEntityDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String zipCode = request.getParameter("zipCode");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        UserEntityDto user = new UserEntityDto(username, firstName, name, email, zipCode, password);
        if (user.register()) {
            session.setAttribute("username", username);
            dispatcher = request.getRequestDispatcher("registerSuccess.jsp");
        } else {
            session.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("register.jsp");
        }

        dispatcher.forward(request, response);
    }

}
