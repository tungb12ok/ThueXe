/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.StatusDAO;
import DAO.VehicleDAO;
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
import java.util.List;

/**
 *
 * @author tungl
 */
@WebServlet(name = "ManagerController", urlPatterns = {"/manager"})
public class ManagerController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VehicleDAO vDAO = new VehicleDAO();
        HttpSession session = request.getSession();

        User u = (User) session.getAttribute("user");
        if (u == null) {
            response.sendRedirect("login");
            return;
        }
        List<Vehicle> listV = vDAO.getAllVehicles();
        request.setAttribute("listV", listV);
        request.getRequestDispatcher("manager.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
