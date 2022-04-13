package com.supinfo.servlets;

import com.supinfo.DAO.ObjectEntityDAO;
import com.supinfo.Dto.ObjectEntityDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/objectDetails")
public class ObjectDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String objectId = request.getParameter("objectId");
        RequestDispatcher dispatcher = null;

        ObjectEntityDto object = new ObjectEntityDAO().getObjectById(objectId);
        request.setAttribute("name", object.getName());
        request.setAttribute("description", object.getDescription());
        request.setAttribute("price", object.getPrice());
        request.setAttribute("encode", object.getEncode());
        request.setAttribute("username", object.getUser().getUsername());
        request.setAttribute("email", object.getUser().getEmail());
        dispatcher = request.getRequestDispatcher("objectDetails.jsp");
        dispatcher.forward(request, response);
    }
}
