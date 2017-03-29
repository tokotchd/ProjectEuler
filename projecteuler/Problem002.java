package projecteuler;

public class Problem002 
{
	public static void main(String[] args)
	{
		int summation = 2;
		int fib1 = 1;
		int fib2 = 2;
		int fibNext;
		while(fib2 < 4000000)
		{
			fibNext = fib1+fib2;
			fib1 = fib2;
			fib2 = fibNext;
			if(fibNext %2 == 0)
			{
				System.out.println(fibNext);
				summation += fibNext;
			}
		}
		System.out.println(summation);
	}
	
	public static int nextFib(int fib1, int fib2)
	{
		return fib1+fib2;
	}
}
