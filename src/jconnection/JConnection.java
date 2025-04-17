/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user"; // Database URL
        String user = "root"; // Default XAMPP username
        String password = ""; // Default XAMPP password is empty

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            try ( // Establish Connection
                    Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connected to MySQL!");

                try ( // Create and Execute SQL Query
                        Statement stmt = conn.createStatement(); ResultSet rs
                        = stmt.executeQuery("SELECT * FROM user1")) {

                    // Print Data
                    while (rs.next()) {
                        System.out.println("ID: " + rs.getInt("ID")
                                + ", Name: " + rs.getString("Name")
                                + ", Email: " + rs.getString("Email"));
                    }
                    // Close Connection
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }
}
