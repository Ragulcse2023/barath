package Solution;

import java.util.List;
import java.util.Random;
import java.util.*;

class seperate
{
	private Map<String,Integer> map = new HashMap<>();
	public void setMap(Map<String,Integer> map)
	{
		this.map = map;
	}
	public List<String> ListSeperation (int s, int e)
	{
		List<String> lis = new ArrayList<>();
		for(Map.Entry<String,Integer> mmp : map.entrySet())
		{
			if(mmp.getValue()>s && mmp.getValue()<e)
			{
				lis.add(mmp.getKey());
			}
		}
		
		return lis;
	}
}
public class listMan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	Map<String,Integer> map = new HashMap<>();
	map.put("bata", 13);
	map.put("lee", 93);
	map.put("lp", 34);
	map.put("as", 43);
	map.put("th", 83);
	map.put("hh", 44);
	seperate s = new seperate();
	s.setMap(map);
	
	System.out.println("Enter the start value");
	int start =sc.nextInt();
	int end = sc.nextInt();
	
	List<String> toDis = s.ListSeperation(start, end);
	System.out.println(toDis);
	
	}
		

	}
