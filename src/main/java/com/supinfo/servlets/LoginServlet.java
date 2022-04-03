package com.supinfo.servlets;

import com.supinfo.datasource.MyDataSource;
import com.supinfo.myEntities.User;

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

        User user = new User(username, password);
        if (user.login()) {
            session.setAttribute("username", username);
            dispatcher = request.getRequestDispatcher("index.jsp");
        } else {
            session.setAttribute("status", "failed");
            dispatcher = request.getRequestDispatcher("login.jsp");
        }

        dispatcher.forward(request, response);
    }
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.print("Get");
////        if (session != null) {
////            String username = (String) session.getAttribute("username");
////            out.print(username);
////        } else out.print("Pas de session !");
////        out.close();
//    }
}
