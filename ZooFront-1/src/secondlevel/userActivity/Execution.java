package com.Zoo.userActivity;

import java.util.Scanner;

import com.Zoo.DAO.animalDAO;
import com.Zoo.DAO.employeeDAO;
import com.Zoo.DAO.foodDAO;
import com.Zoo.DAO.habitatDAO;
import com.Zoo.DAO.veterinarianDAO;
import com.Zoo.DAO.visitorDAO;
import com.Zoo.beans.animalBeans;
import com.Zoo.beans.employeeBeans;
import com.Zoo.beans.foodBeans;
import com.Zoo.beans.habitatBeans;
import com.Zoo.beans.veterinarianBeans;
//import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.Zoo.beans.visitorBeans;

////replaced zookeeper with employee
//
//package com.Zoo.userActivity;
//
//import com.Zoo.DAO.Delete;
//import com.Zoo.DAO.Insert;
//import com.Zoo.DAO.Update;
//import com.Zoo.DAO.view;
//
//public class Execution {
//	
//	
// void executeAdmin(view v,Insert i,Update u,Delete del, int fo,int op)
// {
//	 switch (fo) {
//     case 1:
//         if (op == 1) v.viewAnimals();
//         else if (op == 2) i.insertAnimals();
//         else if (op == 3) del.deleteAnimal();
//         else if (op == 4) u.updateAnimal(); // Assuming you have an 'updateAnimal' method
//         break;
//     case 2:
//         if (op == 1) v.viewFood();
//         else if (op == 2) i.insertFood();
//         else if (op == 3) del.deleteFood();
//         else if (op == 4) u.updateFood(); // Assuming you have an 'updateFood' method
//         break;
//     case 3:
//         if (op == 1) v.viewHabitat();
//         else if (op == 2) i.insertHabitat();
//         else if (op == 3) del.deleteHabitat();
//         else if (op == 4) u.updateHabitat(); // Assuming you have an 'updateHabitat' method
//         break;
//     case 4:
//         if (op == 1) v.viewVeterinarian();
//         else if (op == 2) i.insertVeterinarian();
//         else if (op == 3) del.deleteVeterinarian();
//         else if (op == 4) u.updateVeterinarian(); // Assuming you have an 'updateVeterinarian' method
//         break;
//     case 5:
//         if (op == 1) v.viewVisitor();
//         else if (op == 2) i.insertVisitor();
//         else if (op == 3) del.deleteVisitor();
//         else if (op == 4) u.updateVisitor(); // Assuming you have an 'updateVisitor' method
//         break;
//     case 6:
//         if (op == 1) v.viewEmployee();
//         else if (op == 2) i.insertEmployee();
//         else if (op == 3) del.deleteEmployee();
//         else if (op == 4) u.updateEmployee(); // Assuming you have an 'updateemployee' method
//         break;
//     default:
//         System.out.println("Invalid option");
//         break;
//	 }	 
// }
// 
// void executeEmployee(Update u,int fir)
// {
//	 switch(fir)
//	 {
//	 case 1: u.updateAnimal();
//	 break;
//	 case 2: u.updateFood();
//	 break;
//	 case 3: u.updateHabitat();
//	 break;
//	 case 4: u.updateVeterinarian();
//	 break;
//	 case 5: u.updateEmployee();
//	 break;
//	 case 6: u.updateVisitor();
//	 break;
//	 }
// }
// 
//}


	//animalDAO a = new animalDAO();

public class Execution {
	
	animalDAO a = new animalDAO();
    employeeDAO e = new employeeDAO();
    foodDAO f = new foodDAO();
    habitatDAO h = new habitatDAO();
    veterinarianDAO ve = new veterinarianDAO();
    visitorDAO vi = new visitorDAO();
    
    
    
    void executeAdmin( animalDAO a, foodDAO f, habitatDAO h, veterinarianDAO ve, employeeDAO e, visitorDAO vi, int fo, int op) {
        switch (fo) {
            case 1:
                if (op == 1) a.viewAnimals();
                else if (op == 2) a.insertAnimal(new animalBeans()); // You'll need to create and pass an Animal object here
                else if (op == 3) a.deleteAnimal(0); // You'll need to pass the id of the animal to delete
                else if (op == 4) a.updateAnimal(0, "", ""); // You'll need to pass the id of the animal to update, the attribute to update, and the new value
                break;
            case 2:
                if (op == 1) f.viewFood();
                else if (op == 2) f.insertFood(new foodBeans());
                else if (op == 3) f.deleteFood(0);
                else if (op == 4) f.updateFood(0, "", "");
                break;
            case 3:
                if (op == 1) h.viewHabitat();
                else if (op == 2) h.insertHabitat(new habitatBeans());
                else if (op == 3) h.deleteHabitat(0);
                else if (op == 4) h.updateHabitat(0, "", "");
                break;
            case 4:
                if (op == 1) ve.viewVeterinarian();
                else if (op == 2) ve.insertVeterinarian(new veterinarianBeans());
                else if (op == 3) ve.deleteVeterinarian(0);
                else if (op == 4) ve.updateVeterinarian(0, "", "");
                break;
            case 5:
                if (op == 1) vi.viewVisitor();
                else if (op == 2) vi.insertVisitor(new visitorBeans());
                else if (op == 3) vi.deleteVisitor(0);
                else if (op == 4) vi.updateVisitor(0, "", "");
                break;
            case 6:
                if (op == 1) e.viewEmployee();
                else if (op == 2) e.insertEmployee(new employeeBeans());
                else if (op == 3) e.deleteEmployee(0);
                else if (op == 4) e.updateEmployee(0, "", "");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    
    void executeEmployee(int fir) {
        Scanner sc = new Scanner(System.in);
        switch (fir) {
            case 1:
                System.out.println("Which attribute of Animal would you like to update?");
                System.out.println("1.Name \n2.Origin \n3.Diet \n4.Species \n5.Weight \n6.Age \n7.Health Status");
                int attributeOption = sc.nextInt();
                System.out.println("Enter the new value for the attribute:");
                String newValue = sc.next();
                a.updateAnimal(0, getAnimalAttributeName(attributeOption), newValue); // You'll need to pass the id of the animal to update
                break;
            case 2:
                System.out.println("Which attribute of Food would you like to update?");
                System.out.println("1.Name \n2.Nutrition Value \n3.Quantity In Stock \n4.Cost \n5.Suitable For");
                attributeOption = sc.nextInt();
                System.out.println("Enter the new value for the attribute:");
                newValue = sc.next();
                f.updateFood(0, getFoodAttributeName(attributeOption), newValue); // You'll need to pass the id of the food to update
                break;
            case 3:
                System.out.println("Which attribute of Habitat would you like to update?");
                System.out.println("1.Name \n2.Type \n3.Capacity \n4.Location \n5.Size \n6.Temperature Control \n7.Is Clean");
                attributeOption = sc.nextInt();
                System.out.println("Enter the new value for the attribute:");
                newValue = sc.next();
                h.updateHabitat(0, getHabitatAttributeName(attributeOption), newValue); // You'll need to pass the id of the habitat to update
                break;
            case 4:
                System.out.println("Which attribute of Veterinarian would you like to update?");
                System.out.println("1.Name \n2.Specialization \n3.Shift \n4.Date Of Joining");
                attributeOption = sc.nextInt();
                System.out.println("Enter the new value for the attribute:");
                newValue = sc.next();
                ve.updateVeterinarian(0, getVeterinarianAttributeName(attributeOption), newValue); // You'll need to pass the id of the veterinarian to update
                break;
            case 5:
                System.out.println("Which attribute of Visitor would you like to update?");
                System.out.println("1.Name \n2.Visit Date \n3.Favorite Animal \n4.Age \n5.Ticket Type \n6.Group Size \n7.in_time \n8.out_time");
                attributeOption = sc.nextInt();
                System.out.println("Enter the new value for the attribute:");
                newValue = sc.next();
                vi.updateVisitor(0, getVisitorAttributeName(attributeOption), newValue); // You'll need to pass the id of the visitor to update
                break;
            case 6:
                System.out.println("Which attribute of Employee would you like to update?");
                System.out.println("1.Name \n2.Experience \n3.Habitat \n4.Date Of Joining");
                attributeOption = sc.nextInt();
                System.out.println("Enter the new value for the attribute:");
                newValue = sc.next();
                e.updateEmployee(0, getEmployeeAttributeName(attributeOption), newValue); // You'll need to pass the id of the employee to update
                break;
        }
    }

    String getAnimalAttributeName(int option) {
        switch (option) {
            case 1: return "name";
            case 2: return "origin";
            case 3: return "diet";
            case 4: return "species";
            case 5: return "weight";
            case 6: return "age";
            case 7: return "healthStatus";
            default: return "";
        }
    }

    String getFoodAttributeName(int option) {
        switch (option) {
            case 1: return "name";
            case 2: return "nutritionValue";
            case 3: return "quantityInStock";
            case 4: return "cost";
            case 5: return "suitableFor";
            default: return "";
        }
    }

    String getHabitatAttributeName(int option) {
        switch (option) {
            case 1: return "name";
            case 2: return "type";
            case 3: return "capacity";
            case 4: return "location";
            case 5: return "size";
            case 6: return "temperatureControl";
            case 7: return "isClean";
            default: return "";
        }
    }

    String getVeterinarianAttributeName(int option) {
        switch (option) {
            case 1: return "name";
            case 2: return "specialization";
            case 3: return "shift";
            case 4: return "dateOfJoining";
            default: return "";
        }
    }

    String getVisitorAttributeName(int option) {
        switch (option) {
            case 1: return "name";
            case 2: return "visitDate";
            case 3: return "favoriteAnimal";
            case 4: return "age";
            case 5: return "ticketType";
            case 6: return "groupSize";
            default: return "";
        }
    }

    String getEmployeeAttributeName(int option) {
        switch (option) {
            case 1: return "name";
            case 2: return "experience";
            case 3: return "habitat";
            case 4: return "dateOfJoining";
            default: return "";
        }
    }

    }




