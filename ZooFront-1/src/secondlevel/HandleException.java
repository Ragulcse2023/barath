import java.util.*;
public class HandleException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number one");
		int o = sc.nextInt();
		System.out.println("Enter number two");
		int t = sc.nextInt();
		try
		{
			System.out.println(o/t);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("Adding o with 3  " + (o+3) + " another " + (t+2));
		}
	}

}
