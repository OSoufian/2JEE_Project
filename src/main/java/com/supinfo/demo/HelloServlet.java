package com.supinfo.demo;

import com.supinfo.DAOFactories.DAOFactory;
import com.supinfo.DAOFactories.UserEntityDAO;
import com.supinfo.entities.UserEntityDto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserEntityDAO userEntityDao;

    public void init() throws ServletException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        this.userEntityDao = daoFactory.getUserEntityDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", userEntityDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setName(request.getParameter("nom"));
        userEntityDto.setFirstName(request.getParameter("prenom"));

        userEntityDao.add(userEntityDto);

        request.setAttribute("user", userEntityDao.lister());

        this.getServletContext().getRequestDispatcher("/WEB-INF/login-success.xhtml").forward(request, response);
    }

}