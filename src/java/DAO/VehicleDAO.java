package DAO;

import Model.Vehicle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleDAO extends DBContext {

    // Method to retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [dbo].[Vehicle]")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleID(rs.getInt("vehicleID"));
                    vehicle.setName(rs.getString("name"));
                    vehicle.setImage(rs.getString("image"));
                    vehicle.setDescription(rs.getString("description"));
                    vehicle.setPrice(rs.getDouble("price"));
                    vehicle.setStatus(rs.getInt("status"));
                    vehicleList.add(vehicle);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicleList;
    }
// Method to retrieve all vehicles with status = 1

    public List<Vehicle> getAllVehiclesWithAcitve() {
        List<Vehicle> vehicleList = new ArrayList<>();
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [dbo].[Vehicle] WHERE status = 1")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleID(rs.getInt("vehicleID"));
                    vehicle.setName(rs.getString("name"));
                    vehicle.setImage(rs.getString("image"));
                    vehicle.setDescription(rs.getString("description"));
                    vehicle.setPrice(rs.getDouble("price"));
                    vehicle.setStatus(rs.getInt("status"));
                    vehicleList.add(vehicle);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicleList;
    }

    // Method to delete a vehicle
    public void deleteVehicle(int vehicleID) {
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("DELETE FROM [dbo].[Vehicle] WHERE vehicleID = ?")) {
            stmt.setInt(1, vehicleID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void add(Vehicle vehicle) {
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("INSERT INTO [dbo].[Vehicle] (name, description, price, image, status) VALUES (?, ?, ?, ?, ?)")) {
            stmt.setString(1, vehicle.getName());
            stmt.setString(2, vehicle.getDescription());
            stmt.setDouble(3, vehicle.getPrice());
            stmt.setString(4, vehicle.getImage());
            stmt.setInt(5, vehicle.getStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(Vehicle vehicle) {
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("UPDATE [dbo].[Vehicle] SET name = ?, description = ?, price = ?, image = ?, status = ? WHERE vehicleID = ?")) {
            stmt.setString(1, vehicle.getName());
            stmt.setString(2, vehicle.getDescription());
            stmt.setDouble(3, vehicle.getPrice());
            stmt.setString(4, vehicle.getImage());
            stmt.setInt(5, vehicle.getStatus());
            stmt.setInt(6, vehicle.getVehicleID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// Method to retrieve a vehicle by its ID

    public Vehicle getVehicleById(int vehicleId) {
        Vehicle vehicle = null;
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [dbo].[Vehicle] WHERE vehicleID = ?")) {
            stmt.setInt(1, vehicleId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vehicle = new Vehicle();
                    vehicle.setVehicleID(rs.getInt("vehicleID"));
                    vehicle.setName(rs.getString("name"));
                    vehicle.setDescription(rs.getString("description"));
                    vehicle.setPrice(rs.getDouble("price"));
                    vehicle.setImage(rs.getString("image"));
                    vehicle.setStatus(rs.getInt("status"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(VehicleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicle;
    }

    public static void main(String[] args) {
        VehicleDAO vehicleDAO = new VehicleDAO();
//        Vehicle v = vehicleDAO.getVehicleById(1);
//        v.setStatus(2);
//        vehicleDAO.deleteVehicle(11);
//        vehicleDAO.update(v);
        System.out.println(vehicleDAO.getAllVehicles());
        System.out.println(vehicleDAO.getAllVehicles());
        System.out.println(vehicleDAO.getAllVehicles());
    }
}
