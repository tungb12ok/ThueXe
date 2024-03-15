/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.UserDAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author tungl
 */
@WebServlet(name = "LoginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDAO uDAO = new UserDAO();
        User u = uDAO.authenticateUser(username, password);
        
        
        if (u == null) {
            session.setAttribute("messError", "Username or password incrrect!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            session.setAttribute("messSuccess", "login successfuly!");
            session.setAttribute("user", u);
            if(u.getRole().equals("ADMIN")){
                response.sendRedirect("manager");
            }else{
                response.sendRedirect("home");
            }
        }
    }

}
