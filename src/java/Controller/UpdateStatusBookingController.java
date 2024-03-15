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
@WebServlet(name = "UpdateStatusBookingController", urlPatterns = {"/updateStatus"})
public class UpdateStatusBookingController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String status = request.getParameter("status");

        BookingDAO bDAO = new BookingDAO();
        VehicleDAO vDAO = new VehicleDAO();
        try {
            Booking b = bDAO.getBookingById(Integer.parseInt(id));
            Vehicle v = vDAO.getVehicleById(b.getVehicleID());

            if (status.equals("5")) {
                v.setStatus(2);
            }
            if (status.equals("8")) {
                v.setStatus(1);
                b.setStatus(8);
            } else {
                b.setStatus(Integer.parseInt(status));
            }
            bDAO.updateBooking(b);
            vDAO.update(v);
            request.getSession().setAttribute("messSuccess", "Update status successfuly!");
            response.sendRedirect("managerBooking");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
