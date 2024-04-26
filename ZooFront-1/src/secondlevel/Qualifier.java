package Solution;
import java.util.*;

public class Qualifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		String s ="234dfuwfs";
//		System.out.println(s.toUpperCase());
		Map<Integer,String> map = new HashMap<>();
		
		map.put(1, "barath");
		map.put(2, "na");
		map.put(3, "than");
		map.put(4, "my");
		map.put(5, "name");
		map.put(77, "is");
		map.put(5, "bila");
		map.put(6, "naaa");
		map.put(8, "naan");
		map.put(8, "dhan");
		map.put(22, "iru");
		map.put(19, "inga");
		
		
		
		System.out.println(map.containsKey(8));
		System.out.println(map.get(8));
		
		//NOW WE PLAN TO MANIPULATE THE VALUES INN MAP
		//System.out.println(map.get(2));
		System.out.println(map.values());
		System.out.println(map.keySet());
		System.out.println(map.entrySet());
		map.get(5);
		///Now manipulating using entryset
		Integer i =8;
		
		Set<Map.Entry<Integer, String>> sampleset = map.entrySet();
		for(Map.Entry<Integer,String> top : sampleset)
		{
			if(map.containsKey(5))
			{
				System.out.println(map.get(5));
				//sampleset
			}
			
		}
		if(map.containsValue("iru"))
		{
			System.out.println(map.get("iru"));
		}

	}

}
