package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem021 
{
	public static void main(String[] args)
	{
		int amiSum = 0;
		for(int counter = 1; counter < 10000; counter++)
		{
			if(isBiComplementary(counter))
			{
				amiSum += getSumOfProperDivisors(counter);
			}
		}
		System.out.println(amiSum);
	}
	
	private static boolean isBiComplementary(int number)
	{
		return (getSumOfProperDivisors(getSumOfProperDivisors(number)) == number && number != getSumOfProperDivisors(number));
	}
	private static int getSumOfProperDivisors(int number)//returns the sum of all numbers from [1, num) that evenly divide num
	{
		//we start with the list of divisors taken from elsewhere.
		int[] lowerDivisors = getListOfDivisors(number);
		int lowerDivisorsSum = 1;//start at 1 because we ignore 1 as its mirror is = to number.
		//ignoring 1 (at index zero), we go through the list
		for(int counter = 1; counter < lowerDivisors.length; counter++)
		{
			//for each one, we add both it and the quotient of num and it to the master sum, *except* when it is equal to said quotient (to prevent sqrts from appearing in perfect squares twice).
			int thisDivisor = lowerDivisors[counter];
			int complimentDivisor = number/thisDivisor;
			if(thisDivisor != complimentDivisor)
			{
				lowerDivisorsSum += thisDivisor + complimentDivisor;
			}
			else
			{
				lowerDivisorsSum += thisDivisor;
			}
		}
		return lowerDivisorsSum;
	}
	private static int[] getListOfDivisors(int number)//returns all numbers from [1,sqrt(num)] that evenly divide num
	{
		ArrayList<Integer> primesToReturn = new ArrayList<Integer>();
		for(int counter = 1; counter <= Math.sqrt(number); counter++)
		{
			if(number % counter == 0)
			{
				primesToReturn.add(counter);
			}
		}
		int[] thesePrimes = new int[primesToReturn.size()];
		for(int c = 0; c < thesePrimes.length; c++)
		{
			thesePrimes[c] = primesToReturn.get(c);
		}
		return thesePrimes;
	}
}
