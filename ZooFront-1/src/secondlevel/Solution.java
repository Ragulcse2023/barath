import java.util.*;
public class TicketInfo {
	private String name;
	private int noOfTickets;
	private String coach;
	private String mobileNumber;
	private String insurance;
	public TicketInfo()
	{
		super();
	}

	public TicketInfo(String name, int noOfTickets, String coach, String mobileNumber, String insurance) {
		super();
		this.name = name;
		this.noOfTickets = noOfTickets;
		this.coach = coach;
		this.mobileNumber = mobileNumber;
		this.insurance = insurance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public String getCoach() {
		return coach;
	}
	public void setCoach(String coach) {
		this.coach = coach;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}


	public double calculateTicketCost()
	{
		//Fill the code here
		double ticketCost;
		if(coach.equalsIgnoreCase("firstac"))
		{
		    ticketCost = noOfTickets*(2200+(2200*0.05)+(2200*0.045));
		    return ticketCost;
		}
		else if(coach.equalsIgnoreCase("secondac"))
		{
		    ticketCost = noOfTickets*(1700+(1700*0.05)+(1700*0.045));
		    return ticketCost;
		}
		if(coach.equalsIgnoreCase("thirdac"))
		{
		    ticketCost = noOfTickets*(1200+(1200*0.04)+(1200*0.045));
		    return ticketCost;
		}
		if(coach.equalsIgnoreCase("sleeper"))
		{
		    ticketCost = noOfTickets*(520+(520*0.02)+(520*0.045));
		    return ticketCost;
		}
		if(coach.equalsIgnoreCase("unreserve"))
		{
		    ticketCost = noOfTickets*(200);
		    return ticketCost;
		}
		else
		{
		    return -1;
		}
		//return -1;
	}

	public double calculateTotalBookingCost()
	{
		//Fill the code here
		if(insurance.equalsIgnoreCase("yes"))
		{
		    return (calculateTicketCost() + (noOfTickets*49));
		}
		else if(insurance.equalsIgnoreCase("no"))
		{
		    return calculateTicketCost();
		}
		else
		{
		    	return -1;
		}
	
	}

}



//import java.util.Scanner;
public class Solution {
	public static TicketInfo extractDetails(String ticketDetails)
	{
		String[] details = ticketDetails.split(":");
	TicketInfo Tif = new TicketInfo(details[0],Integer.parseInt(details[1]),details[2],details[3],details[4]);
		//Fill the code here
		return Tif;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the passenger details");
		String det = sc.nextLine();
		
		TicketInfo ticketInfo = extractDetails(det);
		System.out.println("Passenger Name: " + ticketInfo.getName());
		System.out.println("Number of Tickets: " + ticketInfo.getNoOfTickets());
		System.out.println("Coach: " + ticketInfo.getCoach());
		System.out.println("Mobile Number: " + ticketInfo.getMobileNumber());
		System.out.println("Insurance Required: "+ticketInfo.getInsurance());
		System.out.println("Total Booking Charg: Rs. " + ticketInfo.calculateTotalBookingCost());
	}

}






