//this program is for revising collection concept
//ALL i Know is collection passes references and not the actual parameters
//so to perform manipulations object needs to be converted into respected types
import java.util.*;
public class Collect {

	public static void main(String[] args) {
		Integer[] ar;
		
		
		///Creation of list and printing it accordingly;
		List<Integer> sam = new ArrayList<>();
		Random obj = new Random();
		for(int i=0;i<5;i++)
		{
			sam.add(obj.nextInt(5));
		}
		
		System.out.println(Collections.binarySearch(sam, 1));;
		sam.retainAll(sam>2);
		System.out.println("Output from ORDINARY LIST " + sam);
		ar=sam.toArray(new Integer[0]);
		System.out.println(ar);
//		for(int i : ar)
//		System.out.println();
		
		
		//For Linkedlist
		List<Integer> link = new LinkedList<>();
		for(int i =0;i<10;i++)
		{
			link.add(obj.nextInt(9));
		}
		link.add(2,10);
		Iterator it = link.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		//System.out.println("Output from Linked LIST" + link);
		//BOTH LIKED AND ARRAY LST DONT PERFORM ANY SORTING 
		// RETRUVAL IS FAST IN ARRAY LIST AND MANIPULATION CAN BE DONE IN LINKED LIST
	}

}
