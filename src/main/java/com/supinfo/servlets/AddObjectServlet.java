package com.supinfo.servlets;

import com.supinfo.myEntities.Object;
import com.supinfo.myEntities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addObject")
@MultipartConfig(maxFileSize = 16177216)
public class AddObjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        User user = (User)session.getAttribute("user");
        Part part = request.getPart("image");

        Object object = new Object(name, description, price, user);
        if (object.add(part)) {
            dispatcher = request.getRequestDispatcher("addObjectSuccess.jsp");
        } else {
            session.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("addObject.jsp");
        }
        dispatcher.forward(request, response);
    }
}
