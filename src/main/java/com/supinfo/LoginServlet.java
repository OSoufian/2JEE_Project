package com.supinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    private HttpSession session;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        String username = request.getParameter("username");
        session = request.getSession();
        session.setAttribute("username", username);

        PrintWriter out = response.getWriter();
        out.print("Post");
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("Get");
        if (session != null) {
            String username = (String) session.getAttribute("username");
            out.print(username);
        } else out.print("Pas de session !");
        out.close();
    }
}
