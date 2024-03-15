/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.StatusDAO;
import DAO.VehicleDAO;
import Model.Vehicle;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tungl
 */
@WebServlet(name = "AddVehicleController", urlPatterns = {"/addVehicle"})
public class AddVehicleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StatusDAO sDAO = new StatusDAO();
            request.setAttribute("listS", sDAO.getAllStatus());
            request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form data
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        double price = Double.parseDouble(request.getParameter("price"));

        // Create a Vehicle object
        Vehicle vehicle = new Vehicle();
        vehicle.setName(name);
        vehicle.setDescription(description);
        vehicle.setPrice(price);
        vehicle.setImage(image);
        vehicle.setStatus(1);

        // Call DAO method to add the vehicle
        VehicleDAO vehicleDAO = new VehicleDAO();
        try {
            vehicleDAO.add(vehicle);
            request.getSession().setAttribute("messSuccess", "Add vehicle successfuly!");
            response.sendRedirect("manager");

        } catch (Exception e) {
            request.getSession().setAttribute("messError", e.getMessage());
            request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
        }

    }
}
