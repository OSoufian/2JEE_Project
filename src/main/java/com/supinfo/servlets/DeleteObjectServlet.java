package com.supinfo.servlets;

import com.supinfo.DAO.ObjectEntityDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteObject")
public class DeleteObjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String objectId = request.getParameter("objectId");


        RequestDispatcher dispatcher = null;

        ObjectEntityDAO objectEntityDAO = new ObjectEntityDAO();
        if (objectEntityDAO.deleteObject(objectId)) {
            dispatcher = request.getRequestDispatcher("objects.jsp");
        }
        dispatcher.forward(request, response);
    }
}
