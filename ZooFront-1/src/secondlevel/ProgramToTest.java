import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class ProgramToTest {

    public static void main(String [] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.nextLine();
        String b = sc.nextLine();
        
//        if(a.length()!=b.length())
//        {
//        	return false;
//        }
        char[] ar1 = new char[a.length()];
        char[] ar2 = new char[b.length()];
        
        
        System.out.println("Checking for anagram");
        
       ar1 = a.toLowerCase().toCharArray();
       ar2 = b.toLowerCase().toCharArray();
       System.out.println(ar1);
       
       Arrays.sort(ar1);
       Arrays.sort(ar2);
       if(Arrays.equals(ar1,ar2))
       {
    	   System.out.println("Anagram");
       }
       else
       {
    	   System.out.println("Not an Anagram");
       }
       
        
    }
}
