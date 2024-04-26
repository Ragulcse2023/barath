package com.Zoo.userActivity;

import java.util.Scanner;

import com.Zoo.DAO.employeeOperations;

public class display {
	Scanner sc = new Scanner(System.in);
	int firstOption()
	{
		
		System.out.println("Enter the operation to be performed form the following");
		System.out.println("1.Animals \n2.Food\n3.Habitat\n4.Veterinarian\n5.Visitor\n6.employee");
		int option = sc.nextInt();
		return option;
	}
	int secondOption()
	{
		System.out.println("Enter the operation to be performed form the following");
		System.out.println("1.View \n2.Insert\n3.Delete\n4.update");
		int option = sc.nextInt();
		return option;
	}
	void toSearchAsVisitor()
	{
		System.out.println("Which animal would you like to search?");
		System.out.println("Lion \nPanther \nTiger \nPython \nElephant \nHornbill \nMandrill \nWarthog \nMeerkat");
		String animalName = sc.nextLine();
		String animals = "Lion Panther Tiger Python Elephant Hornbill Mandrill Warthog Meerkat";

		if (animals.contains(animalName)) {
		    employeeOperations search = new employeeOperations();
		    search.visitorDisplay(animalName);
		} else {
		    System.out.println("Invalid option");
		}

	}
	
	void displayEmployeeAdmin()
	{
		System.out.println("Which table would you like to update:");
		System.out.println("1.Health \n2.Visior Check");
	}
}
