import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s.e
		System.out.println("ENter the string to be searched");
		StringTokenizer st = new StringTokenizer(s," ");
		String search = sc.nextLine();
		//StringTokenizer sea = new StringTokenizer(search,"");
		int count=0;
		while(st.hasMoreTokens())
		{
			String saa = st.nextToken();
			if(saa.equals(search))
			{
				count++;
			}
		}
		System.out.println(count);
	}
}