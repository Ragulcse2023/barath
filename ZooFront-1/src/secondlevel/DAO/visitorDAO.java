package com.Zoo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Zoo.beans.visitorBeans;
import com.Zoo.util.Connectivity;
import com.Zoo.util.mailThings;
//import com.google.protobuf.GeneratedMessageLite.Visitor;

public class visitorDAO {
	mailThings mt = new mailThings();
	private Connection connection;

    public visitorDAO() {
        this.connection = Connectivity.getConnection();
    }

    public void insertVisitor(visitorBeans visitor) {
        try {
            String query = "INSERT INTO visitor (name, visitDate, favoriteAnimal, age, ticketType, groupSize) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, visitor.getName());
            pstmt.setString(2, visitor.getVisitDate());
            pstmt.setString(3, visitor.getFavoriteAnimal());
            pstmt.setInt(4, visitor.getAge());
            pstmt.setString(5, visitor.getTicketType());
            pstmt.setInt(6, visitor.getGroupSize());
            pstmt.executeUpdate();
            System.out.println("The visitor details were inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVisitor(int id) {
        try {
            String query = "DELETE FROM visitor WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("The visitor details were deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewVisitor() {
        try {
            String query = "SELECT * FROM visitor";
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", visitDate: " + rs.getString("visitDate") + ", favoriteAnimal: " + rs.getString("favoriteAnimal") + ", age: " + rs.getInt("age") + ", ticketType: " + rs.getString("ticketType") + ", groupSize: " + rs.getInt("groupSize"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateVisitor(int id, String attribute, String newValue) {
        try {
            String query = "UPDATE visitor SET " + attribute + " = ? WHERE id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, newValue);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("The visitor details were updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (attribute.equals("out_time")) {
            mt.checkVisitorsAndNotify(id);
        }
    }
}

