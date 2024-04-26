package com.Zoo.beans;

public class veterinarianBeans {

	// Bean class for Veterinarian
	    private int id;
	    private String name;
	    private String specialization;
	    private String shift;
	    private String dateOfJoining;

	    // getters and setters for each property
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getSpecialization() {
	        return specialization;
	    }

	    public void setSpecialization(String specialization) {
	        this.specialization = specialization;
	    }

	    public String getShift() {
	        return shift;
	    }

	    public void setShift(String shift) {
	        this.shift = shift;
	    }

	    public String getDateOfJoining() {
	        return dateOfJoining;
	    }

	    public void setDateOfJoining(String dateOfJoining) {
	        this.dateOfJoining = dateOfJoining;
	    }
}

	// DAO class for Veterinarian

	// Similarly, create Bean and DAO classes for Employee and Visitor
