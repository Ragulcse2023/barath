abstract class sam
{
	sam()
	{
		System.out.println("in sample constructor");
	}
	void sampl()
	{
		System.out.println("ins am");
	}
	abstract void samppp();
}
abstract class conc extends sam
{
	
	abstract void sam();
}
class noo extends conc
{
	void samppp()
	{
		System.out.println("in sample");
	}
	void sam()
	{
		System.out.println("in samm");
	}
}

class finale extends conc
{
	void samppp()
	{
		System.out.println("in sample");
	}
	void sam()
	{
		System.out.println("in samm");
	}
}
public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		noo n = new noo();
		n.sam();
	}

}


//abstract class sam
//{
//	void sampl()
//	{
//		System.out.println("ins am");
//	}
//	abstract void samppp();
//}
//abstract class conc extends sam
//{
//	abstract void sam();
//}
//class noo extends conc
//{
//	void samppp()
//	{
//		// implementation of samppp
//	}
//	void sam()
//	{
//		// implementation of sam
//	}
//}
//public class Sample {
//
//	public static void main(String[] args) {
//		noo n = new noo();
//		n.sampl();
//	}
//
//}
