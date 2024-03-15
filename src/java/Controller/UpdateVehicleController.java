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

@WebServlet(name = "UpdateVehicleController", urlPatterns = {"/updateVehicle"})
public class UpdateVehicleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        VehicleDAO vDAO = new VehicleDAO();
        try {
            StatusDAO sDAO = new StatusDAO();
            request.setAttribute("listS", sDAO.getAllStatus());
            Vehicle v = vDAO.getVehicleById(Integer.parseInt(id));
            request.setAttribute("vehicle", v);
        } catch (Exception ex) {
            Logger.getLogger(UpdateVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("updateVehicle.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        int vehicleID = Integer.parseInt(request.getParameter("vehicleID"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        int status = Integer.parseInt(request.getParameter("status"));

        Vehicle updatedVehicle = new Vehicle();
        updatedVehicle.setVehicleID(vehicleID);
        updatedVehicle.setName(name);
        updatedVehicle.setDescription(description);
        updatedVehicle.setPrice(price);
        updatedVehicle.setImage(image);
        updatedVehicle.setStatus(status);

        VehicleDAO vehicleDAO = new VehicleDAO();
        try {
            vehicleDAO.update(updatedVehicle);
            request.getSession().setAttribute("messSuccess", "Update successfuly!");
            response.sendRedirect("manager");
            return;
        } catch (Exception e) {
            request.getSession().setAttribute("messError", e.getMessage());
        }
        response.sendRedirect("updateVehicle" + vehicleID);
    }
}
