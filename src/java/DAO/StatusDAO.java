/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Status;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatusDAO extends DBContext {

    Connection connection;

    public StatusDAO() {
        try {
            this.connection = super.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Status> getAllStatus() {
        List<Status> statusList = new ArrayList<>();
        String sql = "SELECT * FROM Status"; // Assuming your table name is "Status"
        try {
            Connection conn = connection;
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                status.setId(rs.getInt("id"));
                status.setName(rs.getString("name"));
                statusList.add(status);
            }
        } catch (Exception e) {
        }
        return statusList;
    }

    public Status getStatusById(int id) {
        String sql = "SELECT * FROM Status WHERE id = ?";
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Status status = new Status();
                    status.setId(rs.getInt("id"));
                    status.setName(rs.getString("name"));
                    return status;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; // Return null if status with given id is not found
    }

    public static void main(String[] args) {
        try {
            StatusDAO dao = new StatusDAO();
            System.out.println(dao.getAllStatus());
            System.out.println(dao.getAllStatus());
            System.out.println(dao.getAllStatus());
        } catch (Exception ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
