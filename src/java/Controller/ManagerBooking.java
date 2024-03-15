/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BookingDAO;
import DAO.StatusDAO;
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
@WebServlet(name = "ManagerBooking", urlPatterns = {"/managerBooking"})
public class ManagerBooking extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookingDAO bDAO = new BookingDAO();
         HttpSession session = request.getSession();

        User u = (User) session.getAttribute("user");
        if (u == null) {
            response.sendRedirect("login");
            return;
        }
        StatusDAO sDAO = new StatusDAO();
        
        request.setAttribute("bookL", bDAO.getAllBookings());
        request.setAttribute("sDAO", sDAO);
        request.getRequestDispatcher("managerBooking.jsp").forward(request, response);
    }

  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    
}
