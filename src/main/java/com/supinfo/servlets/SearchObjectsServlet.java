package com.supinfo.servlets;

import com.supinfo.DAO.ObjectEntityDAO;
import com.supinfo.Dto.ObjectEntityDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchObjects")
public class SearchObjectsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("input");
        RequestDispatcher dispatcher = null;
        List<ObjectEntityDto> objects = new ObjectEntityDAO().searchObjects(input);
        request.setAttribute("objects", objects);
        dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
