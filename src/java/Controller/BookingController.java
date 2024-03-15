/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.BookingDAO;
import DAO.VehicleDAO;
import Model.Booking;
import Model.User;
import Model.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;

/**
 *
 * @author tungl
 */
@WebServlet(name = "BookingController", urlPatterns = {"/booking"})
public class BookingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("user");
        if (u == null) {
            response.sendRedirect("login");
            return;
        }

        VehicleDAO vDAO = new VehicleDAO();

        try {
            Vehicle v = vDAO.getVehicleById(Integer.parseInt(id));
            request.setAttribute("vehicle", v);
            request.getRequestDispatcher("booking.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String amount = request.getParameter("amount");

        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("user");
        if (u == null) {
            response.sendRedirect("login");
            return;
        }

        try {
            Booking b = new Booking();
            b.setUserID(u.getUserID());
            b.setVehicleID(Integer.parseInt(id));
            b.setAmount(Double.parseDouble(amount));
            b.setStartDate(Date.valueOf(startDate));
            b.setEndDate(Date.valueOf(endDate));
            b.setStatus(3);
            BookingDAO bDAO = new BookingDAO();
            bDAO.addBooking(b);
            session.setAttribute("messSuccess", "Booking successfuly!");
        } catch (Exception e) {
            session.setAttribute("messError", "Booking Failed!" + e.getMessage());
        }
        response.sendRedirect("home");
    }

}
