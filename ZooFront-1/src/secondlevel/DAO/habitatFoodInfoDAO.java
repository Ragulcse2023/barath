package com.Zoo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Zoo.beans.habitatFoodInfoBeans;
import com.Zoo.util.Connectivity;
public class habitatFoodInfoDAO {
    private Connection connection;

    public habitatFoodInfoDAO() {
        this.connection = Connectivity.getConnection();
    }

    public void insertHabitatFoodInfo(habitatFoodInfoBeans habitatFoodInfo) {
        try {
            String query = "INSERT INTO HabitatFoodInfo (id, name, type, capacity, location, size, temperatureControl, isClean, foodName, quantityInStock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, habitatFoodInfo.getId());
            pstmt.setString(2, habitatFoodInfo.getName());
            pstmt.setString(3, habitatFoodInfo.getType());
            pstmt.setInt(4, habitatFoodInfo.getCapacity());
            pstmt.setString(5, habitatFoodInfo.getLocation());
            pstmt.setDouble(6, habitatFoodInfo.getSize());
            pstmt.setBoolean(7, habitatFoodInfo.isTemperatureControl());
            pstmt.setBoolean(8, habitatFoodInfo.isClean());
            pstmt.setString(9, habitatFoodInfo.getFoodName());
            pstmt.setInt(10, habitatFoodInfo.getQuantityInStock());
            pstmt.executeUpdate();
            System.out.println("The HabitatFoodInfo details were inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHabitatFoodInfo(int id) {
        try {
            String query = "DELETE FROM HabitatFoodInfo WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("The HabitatFoodInfo details were deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewHabitatFoodInfo() {
        try {
            String query = "SELECT * FROM HabitatFoodInfo";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", type: " + rs.getString("type") + ", capacity: " + rs.getInt("capacity") + ", location: " + rs.getString("location") + ", size: " + rs.getDouble("size") + ", temperatureControl: " + rs.getBoolean("temperatureControl") + ", isClean: " + rs.getBoolean("isClean") + ", foodName: " + rs.getString("foodName") + ", quantityInStock: " + rs.getInt("quantityInStock"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHabitatFoodInfo(int id, String attribute, String newValue) {
        try {
            String query = "UPDATE HabitatFoodInfo SET " + attribute + " = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, newValue);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("The HabitatFoodInfo details were updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
