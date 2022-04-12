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

@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String zipCode = request.getParameter("zipCode");
        String password = request.getParameter("password");

        RequestDispatcher dispatcher = null;

        UserEntityDto user = new UserEntityDto(id, username, firstName, name, email, zipCode, password);
        if (user.edit()) {
            dispatcher = request.getRequestDispatcher("editProfileSuccess.jsp");
        } else {
            session.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("editProfile.jsp");
        }

        dispatcher.forward(request, response);
    }
}
