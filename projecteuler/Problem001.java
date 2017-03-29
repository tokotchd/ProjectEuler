package projecteuler;

public class Problem001 
{
	public static void main(String[] args)
	{
		int summation = 0;
		for(int counter = 0; counter < 1000; counter++)
		{
			if(counter % 3 == 0 || counter % 5 == 0)
			{
				summation+=counter;
			}
		}
		System.out.println(summation);
	}
}
