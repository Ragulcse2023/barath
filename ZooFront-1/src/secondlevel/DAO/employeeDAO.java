package com.Zoo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Zoo.beans.employeeBeans;
import com.Zoo.util.Connectivity;

public class employeeDAO {
    private Connection connection;

    public employeeDAO() {
        this.connection = Connectivity.getConnection();
    }

    public void insertEmployee(employeeBeans employee) {
        try {
            String query = "INSERT INTO employee (name, experience, habitat, dateOfJoining) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, employee.getName());
            pstmt.setInt(2, employee.getExperience());
            pstmt.setString(3, employee.getHabitat());
            pstmt.setString(4, employee.getDateOfJoining());
            pstmt.executeUpdate();
            System.out.println("The employee details were inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id) {
        try {
            String query = "DELETE FROM employee WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("The employee details were deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewEmployee() {
        try {
            String query = "SELECT * FROM employee";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", experience: " + rs.getInt("experience") + ", habitat: " + rs.getString("habitat") + ", dateOfJoining: " + rs.getString("dateOfJoining"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(int id, String attribute, String newValue) {
        try {
            String query = "UPDATE employee SET " + attribute + " = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, newValue);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("The employee details were updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}