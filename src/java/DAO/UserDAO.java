/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO extends DBContext {

    // Method to add a new user
    public void addUser(User user) {
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("INSERT INTO [dbo].[User] (username, email, password, address, phone, role, status) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getRole());
            stmt.setInt(7, user.getStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to update an existing user
    public void updateUser(User user) {
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("UPDATE [dbo].[User] SET username=?, email=?, password=?, address=?, phone=?, role=?, status=? WHERE userID=?")) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getPhone());
            stmt.setString(6, user.getRole());
            stmt.setInt(7, user.getStatus());
            stmt.setInt(8, user.getUserID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Method to authenticate user login
    public User authenticateUser(String username, String password) {
        User user = null;
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [dbo].[User] WHERE [username]=? AND [password]=?")) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserID(rs.getInt("userID"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAddress(rs.getString("address"));
                    user.setPhone(rs.getString("phone"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getInt("status"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
// Method to retrieve a user by userID

    public User getUserByID(int userID) {
        User user = null;
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [dbo].[User] WHERE [userID] = ?")) {
            stmt.setInt(1, userID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    user = new User();
                    user.setUserID(rs.getInt("userID"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAddress(rs.getString("address"));
                    user.setPhone(rs.getString("phone"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getInt("status"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (Connection conn = super.getConnection(); PreparedStatement stmt = conn.prepareStatement("SELECT * FROM [dbo].[User]")) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("userID"));
                    user.setUsername(rs.getString("username"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setAddress(rs.getString("address"));
                    user.setPhone(rs.getString("phone"));
                    user.setRole(rs.getString("role"));
                    user.setStatus(rs.getInt("status"));
                    userList.add(user);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        System.out.println(dao.getUserByID(1));
    }
}
