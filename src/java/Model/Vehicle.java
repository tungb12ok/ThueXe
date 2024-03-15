/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import lombok.Data;

@Data
public class Vehicle {
    private int vehicleID;
    private String name;
    private String description;
    private double price;
    private String image;
    private int status;
}
