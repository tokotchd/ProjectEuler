package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem030 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int counter = 10; counter < 400000; counter++)//single digits do not count as per instructions and 400k was decided as a ballpark upper limit through some experimentation.
		{
			int[] digits = getDigits(counter);
			long sum = 0;
			for(int c : digits)
			{
				sum += Math.pow(c, 5);
			}
			if(sum == counter)
			{
				numbers.add(counter);
			}
		}
		System.out.println(numbers);
		int totalSum = 0;
		for(Integer i: numbers)
		{
			totalSum += i;
		}
		System.out.println(totalSum);
	}
	public static int[] getDigits(int number)
	{
		String strung = Integer.toString(number);
		int[] returnThis = new int[strung.length()];
		for(int counter = 0; counter < strung.length(); counter++)
		{
			returnThis[counter] = Integer.parseInt(strung.substring(counter, counter+1));
		}
		return returnThis;
	}
}
