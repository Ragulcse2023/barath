// inference can be that some of set dont allow repetation and some may allow repetition

// so 
import java.util.Random;
import java.util.*;
public class SetSamples {

	public static void main(String[] args) {
		Set<Integer> sam = new HashSet<>();
		Set<Integer> link = new LinkedHashSet<>();
		
		
		Set<Integer> sort = new TreeSet<>();
		
		sam.add(21);
		sam.add(84);
		sam.add(23);
		sam.add(9);
		sam.add(5);
		sam.add(4);
		sam.add(3);
		sam.add(6);
		sam.add(3);
		sam.add(11);
		
		System.out.println("Hash Set before removing and adding" + sam);
		
		
		sam.add(2467);
		sam.add(34);
		
		System.out.println("Hash Set after removing and adding" + sam);
		
		
		//inference is set dont allow repeating of elements;
		
		
		
		
		//FOR HASHSET IE. LINKED
		
		
		link.add(21);
		link.add(84);
		link.add(23);
		link.add(9);
		link.add(5);
		link.add(4);
		link.add(3);
		link.add(6);
		link.add(3);
		link.add(11);
		
		System.out.println("LinkedHash Set before removing and adding" + link);
		
		
		link.add(2467);
		link.add(34);
		
		System.out.println("Linked Hash Set after removing and adding" + link);
		
		
		// Inference is this maintains the order of insertion
		
		
		
		sort.add(21);
		sort.add(84);
		sort.add(23);
		sort.add(9);
		sort.add(5);
		sort.add(4);
		sort.add(3);
		sort.add(6);
		sort.add(3);
		sort.add(11);
		
		System.out.println("LinkedHash Set before removing and adding" + sort);
		
		
		sort.add(2467);
		sort.add(34);
		
		System.out.println("sorted Hash Set after removing and adding" + sort);
		//inference is it sorts
	}
}