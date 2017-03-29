package projecteuler;

import java.util.ArrayList;

public class Problem023 
{
	private static final int MAX = 28123;
	public static void main(String[] args)
	{
		//create list of abundant numbers
		ArrayList<Integer> abundantNumbers = new ArrayList<Integer>();
		for(int counter = 12; counter < MAX; counter++)
		{
			if(isAbundant(counter))
				abundantNumbers.add(counter);
		}
		boolean isSummable[] = new boolean[MAX];
		for(int counter = 0; counter < isSummable.length; counter++)
		{
			isSummable[counter] = false;
		}
		
		for(int index1 = 0; index1 < abundantNumbers.size(); index1++)
		{
			int abundant1 = abundantNumbers.get(index1);
			for(int index2 = index1; index2 < abundantNumbers.size(); index2++)
			{
				int abundant2 = abundantNumbers.get(index2);
				if(abundant1 + abundant2 > MAX)
				{
					break;
				}
				else
				{
					isSummable[abundant1 + abundant2 - 1] = true;
				}
			}
		}
		int sum = 0;
		for(int counter = 0; counter < isSummable.length; counter++)
		{
			if(!isSummable[counter])
				sum+=counter+1;
		}
		System.out.println(sum);
		
		
	}
	private static boolean isAbundant(int number)
	{
		return getSumOfProperDivisors(number) > number;
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
