import java.util.*;
public class maps {

	public static void main(String[] args) {
		Map<Integer,String> mp = new HashMap<>();
		mp.put(1, "ghj");
		mp.put(3, "sdf");
		mp.put(4, "nbv");
		mp.put(5, "wedf");
		mp.put(6, "ijnb");
		 int[] ar;
		 double d = 0;
		 for(Map.Entry<Integer, String> ent : mp.entrySet())
		 {
			 d=d+ent.getKey();
		 }
		System.out.println(Collections.min(mp.keySet()));
		 System.out.println(d);
		 
		 
		 int[] arr = new int[7];
		 System.out.println(arr.length);
		
	}

}
