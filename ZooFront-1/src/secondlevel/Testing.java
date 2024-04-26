import java.util.Map;
import java.util.Scanner;
import java.util.*;
class Testing
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number of variables");
		int n = sc.nextInt();
		Map<Integer,Integer> sam = new HashMap<Integer,Integer>();
		for(int i =0;i<n;i++)
		{
			System.out.println("enter the key and value");
			sam.put(sc.nextInt(), sc.nextInt());	
		}
		
		
		System.out.println(sam.get(3));
		System.out.println("The entered list is--> " + sam);
		System.out.println(sam.values());
		System.out.println(sam.keySet());
		System.out.println(sam.entrySet());
		System.out.println(sam.containsKey(3));
		
		
		
		Set <Map.Entry<Integer, Integer>> ss = sam.entrySet();
		for(Map.Entry<Integer,Integer> saa : ss)
		{
			System.out.println(saa.getValue()*saa.getKey());
		
		}
	}
}