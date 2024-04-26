package com.Zoo.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.temporal.ChronoUnit;

public class mailThings extends Mail{
	 //Connectivity insertObj = new Connectivity();
	    Connection conn = Connectivity.getConnection();

	public void checkAnimalHealthAndNotifyVet() {	
		    
	    try {
	        String subject = "Animal health Status";
	    	// Create a statement
	    	Statement stmt = conn.createStatement();

	    	// Execute a query to get all animals
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM Animals");

	    	// Create a second statement for the second query
	    	Statement stmt2 = conn.createStatement();
	    	
	    	// Iterate through the result set
	    	while (rs.next()) {
	    	    // Check if the health status of the animal is not healthy
	    	    if (!rs.getString("healthStatus").equals("Healthy")) {
	    	        // Get the id of the veterinarian
	    	        int vetId = rs.getInt("veterinarian_id");
	    	       // String mailid = rs.getString("email");
	    	        // Execute a query to get the veterinarian's details
	    	        ResultSet rsVet = stmt2.executeQuery("SELECT * FROM Veterinarian WHERE id = " + vetId);

	    	        // If the veterinarian exists
	    	        if (rsVet.next()) {
	    	            // Get the veterinarian's name and email
	    	            String vetName = rsVet.getString("name");
	    	            String vetEmail = rsVet.getString("email"); // Assuming the Veterinarian table has an 'email' column

	    	            // Send an email to the veterinarian
	    	            sendEmail("Animal " + rs.getString("name") + " is not feeling well",vetEmail,subject);
	    	        }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void checkVisitorsAndNotify(int id) {
        try {
            // Create a statement
            Statement stmt = conn.createStatement();
            String subject ="Visitor Cost Notification";
            // Execute a query to get all visitors
            ResultSet rs = stmt.executeQuery("SELECT * FROM visitor WHERE id = " + id);

            // Iterate through the result set
            while (rs.next()) {
                // Get the in_time and out_time
                Time inTime = rs.getTime("in_time");
                Time outTime = rs.getTime("out_time");

                // Calculate the difference in hours
                long hours = ChronoUnit.HOURS.between(inTime.toLocalTime(), outTime.toLocalTime());

                // Calculate the cost
                int groupSize = rs.getInt("groupsize");
                double cost = hours * 50 * groupSize;

                // Get the email of the visitor group
                String email = rs.getString("email"); // Assuming the visitor table has an 'email' column
                                // Send an email to the visitor group
                sendEmail( "The cost for your visit is " + cost + " Rs.", email,subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void checkIsClean(int id) {
		System.out.println("in mm");
//	    String query = "SELECT * FROM employee WHERE habitat = ?";
//	    try {
//	        PreparedStatement pstmt = conn.prepareStatement(query);
//	        pstmt.setInt(1, id);
//	        ResultSet rs = pstmt.executeQuery();
//	        while (rs.next()) {
//	            String employeeName = rs.getString("name");
//	            String employeeEmail = rs.getString("email"); // Assuming the 'employee' table has an 'email' column
//	            String subject = "Habitat Cleaning Required";
//	            String message = "Dear " + employeeName + ",\n\nThe habitat with id " + id + " is not clean. Please take the necessary actions.\n\nThank you.";
//	            sendEmail(message, employeeEmail, subject);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    

		
		
		{
		    String queryHabitat = "SELECT name FROM Habitat WHERE id = ?";
		    String queryEmployee = "SELECT * FROM employee WHERE habitat = ?";
		    try {
		        PreparedStatement pstmtHabitat = conn.prepareStatement(queryHabitat);
		        pstmtHabitat.setInt(1, id);
		        ResultSet rsHabitat = pstmtHabitat.executeQuery();

		        if (rsHabitat.next()) {
		            String habitatName = rsHabitat.getString("name");

		            PreparedStatement pstmtEmployee = conn.prepareStatement(queryEmployee);
		            pstmtEmployee.setString(1, habitatName);
		            ResultSet rsEmployee = pstmtEmployee.executeQuery();

		            while (rsEmployee.next()) {
		                String employeeName = rsEmployee.getString("name");
		                String employeeEmail = rsEmployee.getString("email"); // Assuming the 'employee' table has an 'email' column
		                String subject = "Habitat Cleaning Required";
		                String message = "Dear " + employeeName + ",\n\nThe habitat with id " + id + " is not clean. Please take the necessary actions.\n\nThank you.";
		                System.out.println("before mail");
		                sendEmail(message, employeeEmail, subject);
		                System.out.println("after sending");
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}

	}


}
