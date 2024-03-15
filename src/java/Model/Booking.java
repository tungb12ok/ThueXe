/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import lombok.Data;

@Data
public class Booking {
    private int bookingID;
    private int userID;
    private int vehicleID;
    private Date startDate;
    private Date endDate;
    private double amount;
    private int status;
}