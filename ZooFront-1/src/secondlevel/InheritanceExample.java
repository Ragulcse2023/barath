class grandFather
{
	grandFather()
	{
		System.out.println("in grandfather cons");
	}
	void display1()
	{
		System.out.println("in gf display");
	}
}
class Father extends grandFather
{
	void display2()
	{
		System.out.println("in father display");
	}
}
class Son extends Father
{
	
	void display()
	{
		this.display1();
		this.display2();
		System.out.println("in son display");
	}
	
}
public class InheritanceExample
{
	public static void main(String... args)
	{
		
		new Son().display();
	}
}