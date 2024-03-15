/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Booking;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class BookingDAO extends DBContext {

    Connection connection;

    public BookingDAO() {
        try {
            this.connection = super.getConnection();
        } catch (Exception ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Create (Insert) method
    public void addBooking(Booking booking) {
        String query = "INSERT INTO Booking (userID, vehicleID, start_date, end_date, status, amount) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, booking.getUserID());
            preparedStatement.setInt(2, booking.getVehicleID());
            preparedStatement.setDate(3, booking.getStartDate());
            preparedStatement.setDate(4, booking.getEndDate());
            preparedStatement.setInt(5, booking.getStatus());
            preparedStatement.setDouble(6, booking.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Read (Select) method by ID
    public Booking getBookingById(int bookingID) {
        Booking booking = null;
        String query = "SELECT * FROM Booking WHERE bookingID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bookingID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    booking = mapResultSetToBooking(resultSet);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return booking;
    }

    // Update method
    public void updateBooking(Booking booking) throws SQLException {
        String query = "UPDATE Booking SET userID=?, vehicleID=?, start_date=?, end_date=?, status=?, amount=? WHERE bookingID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, booking.getUserID());
            preparedStatement.setInt(2, booking.getVehicleID());
            preparedStatement.setDate(3, booking.getStartDate());
            preparedStatement.setDate(4, booking.getEndDate());
            preparedStatement.setInt(5, booking.getStatus());
            preparedStatement.setDouble(6, booking.getAmount());
            preparedStatement.setInt(7, booking.getBookingID());
            preparedStatement.executeUpdate();
        }
    }

    // Delete method
    public void deleteBooking(int bookingID) throws SQLException {
        String query = "DELETE FROM Booking WHERE bookingID=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, bookingID);
            preparedStatement.executeUpdate();
        }
    }

    // Helper method to map ResultSet to Booking object
    private Booking mapResultSetToBooking(ResultSet resultSet) throws SQLException {
        Booking booking = new Booking();
        booking.setBookingID(resultSet.getInt("bookingID"));
        booking.setUserID(resultSet.getInt("userID"));
        booking.setVehicleID(resultSet.getInt("vehicleID"));
        booking.setStartDate(resultSet.getDate("start_date"));
        booking.setEndDate(resultSet.getDate("end_date"));
        booking.setStatus(resultSet.getInt("status"));
        booking.setAmount(resultSet.getDouble("amount"));
        return booking;
    }

    // Additional method to get all bookings (for listing purposes)
    public List<Booking> getAllBookings(){
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM Booking";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                bookings.add(mapResultSetToBooking(resultSet));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookingDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bookings;
    }

    public static void main(String[] args) {
        BookingDAO bookingDAO = new BookingDAO();

        // Create a new Booking
        Booking newBooking = new Booking();
        newBooking.setUserID(1);
        newBooking.setVehicleID(1);
        newBooking.setStartDate(Date.valueOf("2024-03-15"));
        newBooking.setEndDate(Date.valueOf("2024-03-20"));
        newBooking.setStatus(1);
        newBooking.setAmount(150.0);
        bookingDAO.addBooking(newBooking);
        System.out.println(bookingDAO.getAllBookings());
        System.out.println("Booking added successfully.");
        
//            // Read a Booking by ID
//            Booking retrievedBooking = bookingDAO.getBookingById(1);
//            System.out.println("Retrieved Booking: " + retrievedBooking);
//
//            // Update the Booking
//            retrievedBooking.setAmount(180.0);
//            bookingDAO.updateBooking(retrievedBooking);
//            System.out.println("Booking updated successfully.");
//
//            // Read all Bookings
//            List<Booking> allBookings = bookingDAO.getAllBookings();
//            System.out.println("All Bookings: " + allBookings);
//
//            // Delete the Booking
//            bookingDAO.deleteBooking(retrievedBooking.getBookingID());
//            System.out.println("Booking deleted successfully.");
    }
}
