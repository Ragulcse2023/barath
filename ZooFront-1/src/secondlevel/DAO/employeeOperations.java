package com.Zoo.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Zoo.util.Connectivity;
public class employeeOperations{
		 
    public void visitorDisplay(String attribute) {
        try {
        	//Connectivity insertObj = new Connectivity();
		 Connection conn = Connectivity.getConnection();

            String query = "SELECT a.name, a.age, a.weight, a.origin, f.name AS food " +
                           "FROM Animals a " +
                           "JOIN Food f ON a.species = f.suitableFor " +
                           "WHERE a.species = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, attribute);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Weight: " + rs.getBigDecimal("weight"));
                System.out.println("Origin: " + rs.getString("origin"));
                System.out.println("Food: " + rs.getString("food"));
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
