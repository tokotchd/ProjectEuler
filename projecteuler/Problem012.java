package projecteuler;

public class Problem012 
{
	public static void main(String[] args)
	{
		int thisTriangleNumber = 1;
		int thisNumber = 2;
		while(numberOfDivisors(thisTriangleNumber) <= 500)
		{
			//System.out.print(thisNumber - 1 + " " );//off by one because first thisNumber should be 2, but the "number" is 1
			//System.out.print(thisTriangleNumber + " ");
			//System.out.println(numberOfDivisors(thisTriangleNumber));
			thisTriangleNumber += thisNumber++;
		}
		System.out.print(thisNumber - 1 + " " );
		System.out.print(thisTriangleNumber + " ");
		System.out.println(numberOfDivisors(thisTriangleNumber));
	}
	private static int numberOfDivisors(int numberToDivide)
	{
		int numberOfDivisors = 0;
		for(int counter = 1; counter <= Math.ceil(Math.sqrt(numberToDivide)); counter++)
		{
			if(numberToDivide % counter == 0)
			{
				numberOfDivisors+=2;
			}
		}
		return numberOfDivisors;
	}
}
