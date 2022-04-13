package com.supinfo.servlets;

import com.supinfo.Dto.ObjectEntityDto;
import com.supinfo.Dto.UserEntityDto;

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
        UserEntityDto user = (UserEntityDto) session.getAttribute("user"); ;
        Part part = request.getPart("image");

        ObjectEntityDto object = new ObjectEntityDto(name, description, price, user);
        if (object.add(part)) {
            dispatcher = request.getRequestDispatcher("addObjectSuccess.jsp");
        } else {
            request.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("addObject.jsp");
        }
        dispatcher.forward(request, response);
    }
}
