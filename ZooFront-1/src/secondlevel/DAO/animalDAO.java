package com.Zoo.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Zoo.beans.animalBeans;
import com.Zoo.util.Connectivity;

//DAO class for Animal
public class animalDAO {
 private Connection connection;

 public animalDAO() {
     this.connection = Connectivity.getConnection();
 }

 public void insertAnimal(animalBeans animal) {
     try {
         String query = "INSERT INTO animals (name, origin, diet, species, weight, age, healthStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
         PreparedStatement pstmt = connection.prepareStatement(query);
         pstmt.setString(1, animal.getName());
         pstmt.setString(2, animal.getOrigin());
         pstmt.setString(3, animal.getDiet());
         pstmt.setString(4, animal.getSpecies());
         pstmt.setDouble(5, animal.getWeight());
         pstmt.setInt(6, animal.getAge());
         pstmt.setString(7, animal.getHealthStatus());
         pstmt.executeUpdate();
         System.out.println("The animal details were inserted successfully!");
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void deleteAnimal(int id) {
     try {
         String query = "DELETE FROM animals WHERE id = ?";
         PreparedStatement pstmt = connection.prepareStatement(query);
         pstmt.setInt(1, id);
         pstmt.executeUpdate();
         System.out.println("The animal details were deleted successfully!");
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void viewAnimals() {
     try {
         String query = "SELECT * FROM animals";
         PreparedStatement pstmt = connection.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
             System.out.println("id: " + rs.getInt("id") + ", name: " + rs.getString("name") + ", origin: " + rs.getString("origin") + ", diet: " + rs.getString("diet") + ", species: " + rs.getString("species") + ", weight: " + rs.getDouble("weight") + ", age: " + rs.getInt("age") + ", healthStatus: " + rs.getString("healthStatus"));
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

// public void updateAnimal(Animal animal) {
//     try {
//         String query = "UPDATE animals SET name = ?, origin = ?, diet = ?, species = ?, weight = ?, age = ?, healthStatus = ? WHERE id = ?";
//         PreparedStatement pstmt = connection.prepareStatement(query);
//         pstmt.setString(1, animal.getName());
//         pstmt.setString(2, animal.getOrigin());
//         pstmt.setString(3, animal.getDiet());
//         pstmt.setString(4, animal.getSpecies());
//         pstmt.setDouble(5, animal.getWeight());
//         pstmt.setInt(6, animal.getAge());
//         pstmt.setString(7, animal.getHealthStatus());
//         pstmt.setInt(8, animal.getId());
//         pstmt.executeUpdate();
//         System.out.println("The animal details were updated successfully!");
//     } catch (SQLException e) {
//         e.printStackTrace();
//     }
// }
 
 
 public void updateAnimal(int id, String attribute, String newValue) {
	    try {
	        String query = "UPDATE animals SET " + attribute + " = ? WHERE id = ?";
	        PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, newValue);
	        pstmt.setInt(2, id);
	        pstmt.executeUpdate();
	        System.out.println("The animal details were updated successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
