package day4_assignment1;

public class Program4 {

	public static void main(String[] args)
	{
		Program4 obj= new Program4();
		obj.sum();
		obj.mul();
		obj.div();
		obj.sub();

	}
	public void sum()
	{
		int a= 10;
		double b= 30.8;
		
		double c=a+b;
		System.out.println("Result of sum is "+c);
	}
	
	public void mul()
	{
		float avg_marks= (float) 60.56;
		byte no_sub= 2;
		
		float total_marks= avg_marks*no_sub;
		
		System.out.println("Total marks is "+total_marks);
				
	}

	public void div()
	{
		int total_fruits= 40;
		short kids= 5;
		
		int fruit_count= total_fruits/kids;
		
		System.out.println("Per head fruit count is "+fruit_count);
		
	}

	public void sub()
	{
		double big_number= 198765.76543;
		float small_number= (float) 567.876;
		
		double sub_number= big_number-small_number;
		
		System.out.println("Substraction is "+sub_number);
	}


}
