package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem027 
{
	static int[] primes = new int[400];
	//brute force
	public static void main(String[] args)
	{
		for(int counter = 0; counter < primes.length; counter++)
		{
			primes[counter] = Lib.primes[counter];
		}
		int maxSize = 0, maxA = -1, maxB = -1;
		for(int a = -999; a <= 999; a++)
		{
			for(int b = -1000; b <= 1000; b++)
			{
				int n = 0, size = 0;
				while(true)
				{
					int sum = (int)(Math.pow(n, 2) + a * n + b);
					if(!isPrime(sum))
					{
						break;
					}
					size++;
					n++;
				}
				if(size > maxSize)
				{
					maxSize = size;
					maxA = a;
					maxB = b;
				}
			}
		}
		System.out.println(maxSize + " " + maxA + " " + maxB);
	}
	public static boolean isPrime(int test)
	{
		for(int counter = 0; counter < primes.length; counter++)
		{
			if(primes[counter] == test)
			{
				return true;
			}
		}
		return false;
	}
}
