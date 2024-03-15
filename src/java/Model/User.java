/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import lombok.Data;


@Data
public class User {
    private int userID;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String role;
    private int status;
}
