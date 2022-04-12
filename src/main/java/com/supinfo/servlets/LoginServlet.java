package com.supinfo.servlets;

import com.supinfo.DAO.UserEntityDAO;
import com.supinfo.Dto.UserEntityDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        UserEntityDto user = new UserEntityDto(username, password);
        UserEntityDAO dataSource = new UserEntityDAO();

        if (user.login()) {
            session.setAttribute("username", username);
            session.setAttribute("id", user.getId());
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("name", user.getName());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("zipCode", user.getZipCode());
            session.setAttribute("password", password);
            session.setAttribute("user", user);

            dispatcher = request.getRequestDispatcher("index.jsp");
        } else {
            session.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("login.jsp");
        }

        dispatcher.forward(request, response);
    }
}
