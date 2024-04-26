package com.Zoo.userActivity;
import java.util.Scanner;
import com.Zoo.DAO.animalDAO;
import com.Zoo.DAO.employeeDAO;
import com.Zoo.DAO.foodDAO;
import com.Zoo.DAO.habitatDAO;
import com.Zoo.DAO.veterinarianDAO;
import com.Zoo.DAO.visitorDAO;

//package com.Zoo.userActivity;
//import java.util.Scanner;
//
//import com.Zoo.DAO.Delete;
//import com.Zoo.DAO.Insert;
//import com.Zoo.DAO.Update;
//import com.Zoo.DAO.view;
//public class Operator {
//    public static void main(String[] args) {
//      
//    		Scanner sc = new Scanner(System.in);
//            display d = new display();
//            view v = new view();
//            Insert i = new Insert(); // Assuming you have an 'insert' class
//            Delete del = new Delete(); // Assuming you have a 'delete' class
//            Update u = new Update(); // Assuming you have an 'update' class
//            
//            Execution e = new Execution();
//            
//         
//            
//           
//            
//            
//            System.out.println("Enter Type Of Login \n1.Admin \n2.Employee \n3.Visitor");
//            int option = sc.nextInt();
//            
//            switch(option)
//            {
//            case 1: System.out.println("Welcome Admin");
//	            int fo = d.firstOption();
//	            int op = d.secondOption();
//            	e.executeAdmin(v, i, u, del, fo, op);
//            		
//            break;
//            
//            case 2: System.out.println("Welcome employee \nWhich table you need to update");
//            int fir = d.firstOption();
//            e.executeEmployee(u,fir);
//            
////            mailThings m = new mailThings();
////            m.checkAnimalHealthAndNotifyVet();
////            
//            		
//            break;
//            
//            case 3: System.out.println("Welcome visitor!!");
//            d.toSearchAsVisitor();
//            
//            
//            break;
//            
//            default:
//            	System.out.println("Enter a valid option");
//            	break;
//            }
//            
//    }
//}




public class Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        display d = new display();
       // viewDAO v = new viewDAO();
        animalDAO a = new animalDAO();
        foodDAO f = new foodDAO();
        habitatDAO h = new habitatDAO();
        veterinarianDAO ve = new veterinarianDAO();
        employeeDAO e = new employeeDAO();
        visitorDAO vi = new visitorDAO();
       // Update u = new Update();
        Execution ex = new Execution();

        System.out.println("Enter Type Of Login \n1.Admin \n2.Employee \n3.Visitor");
        int option = sc.nextInt();
        switch(option) {
            case 1:
                System.out.println("Welcome Admin");
                int fo = d.firstOption();
                int op = d.secondOption();
                ex.executeAdmin( a, f, h, ve, e, vi, fo, op);
                break;
            case 2:
                System.out.println("Welcome Employee");
                int fir = d.firstOption();
                ex.executeEmployee( fir);
                break;
            case 3:
                System.out.println("Welcome Visitor");
                d.toSearchAsVisitor();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
}