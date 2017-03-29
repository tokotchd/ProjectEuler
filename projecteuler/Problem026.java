package projecteuler;

import java.util.Arrays;

public class Problem026 
{
	public static void main(String[] args)
	{
		int maxIndex = 1;
		int maxSize = 0;
		for(int counter = 1; counter < 1000; counter++)
		{
			int size = getRepeatSize(1,counter);
			if(maxSize < size)
			{
				maxSize = size;
				maxIndex = counter;
			}
		}
		System.out.println(maxIndex + ":" + maxSize);
		
	}
	private static int getRepeatSize(int numerator, int denominator)
	{
		//this function relies on the idea that all fractions are rational numbers.
		//They are either terminating (which ends up being the case in base 10 number system that the denominator has a factor of 2 or 5)
		//Or they are not, which means that at some point, they are repeating.  
		//To deal with the latter, we simply look for a zero remainder at any given point.  If we get a zero remainder, the decimal terminated, and we return 0.
		//To deal with the former, we keep dividing the remainder by the denominator until we get a remainder that has already been seen.
		//This means that the "repeat cycle" has begun and we have entered the absorption state of the repeating decimal.
		//Once we hit this state, we determine the repeating decimal size by subtracting the indicies of the locations of 
		//the repeated remainder and its first instance's index.  This solves the "chopping" problem for numbers such as 1/6.
		
		int[] remainderIndexArray = new int[denominator];//we can have d unique remainders (from 0 to d - 1, but 0 is a special case.)
		int remainder = numerator;
		for(int counter = 0; counter <= remainderIndexArray.length; counter++)
		{
			remainder = remainder % denominator;
			if (remainder == 0)
			{
				return 0;
			}
			else
			{
				if(remainderIndexArray[remainder] != 0)
				{
					//this is (the first) repeat decimal
					return counter - remainderIndexArray[remainder];
				}
				else
				{
					//it's not a repeat decimal yet.
					remainderIndexArray[remainder] = counter;
				}
				remainder = remainder * 10;
			}
		}
		return -1;//should never get here.
	}
}
