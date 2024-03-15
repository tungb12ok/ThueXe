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

/**
 *
 * @author tungl
 */
@WebServlet(name = "DeleteVehicleController", urlPatterns = {"/deleteVehicle"})
public class DeleteVehicleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        VehicleDAO vDAO = new VehicleDAO();
        if (id != null) {
            try {
                Vehicle v = vDAO.getVehicleById(Integer.parseInt(id));
                v.setStatus(2);
                vDAO.update(v);
                request.getSession().setAttribute("messSuccess", "InActive status vehicle successfuly!");
            } catch (Exception e) {
                request.getSession().setAttribute("messError", "InActive status vehicle failed!");
            }
        }

        response.sendRedirect("manager");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
