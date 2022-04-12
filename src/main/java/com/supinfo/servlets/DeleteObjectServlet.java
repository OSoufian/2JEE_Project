package com.supinfo.servlets;

import com.supinfo.datasource.MyDataSource;
import com.supinfo.myEntities.Object;
import com.supinfo.myEntities.User;

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

        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;

        MyDataSource myDataSource = new MyDataSource();
        if (myDataSource.deleteObject(objectId)) {
            dispatcher = request.getRequestDispatcher("objects.jsp");
        } else {
            session.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("objects.jsp");
        }
        dispatcher.forward(request, response);
    }
}
