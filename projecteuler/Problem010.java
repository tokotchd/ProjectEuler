package projecteuler;
import java.util.ArrayList;

public class Problem010
{
	public static void main(String[] args)
	{
		double lessThanNumber = 2000000;
		
		ArrayList<Double> primes = new ArrayList<Double>(10001);
		//primes.add(new BigInteger("0"));
		//primes.add(new BigInteger("1"));
		primes.add(1d);
		primes.add(2d);
		primes.add(3d);
		
		double thisNumberToCheck = 4;//number to Check is the actual number we are checking to be prime or not.
		double primesSum = 5;//for 2, and 3
		
		while(primes.get(primes.size()-1) <= lessThanNumber)//until our list has 10001 primes
		{
			int divisorPrimeIndex = 1;//the index of the current prime number we are dividing by, start at 1 b/c we need to ignore 1.
			double divisorPrimeValue = primes.get(divisorPrimeIndex);
			boolean isPrime = true;
			while(divisorPrimeValue <= Math.sqrt(thisNumberToCheck))
			{
				if(thisNumberToCheck % divisorPrimeValue == 0)
				{
					//number is not prime
					isPrime = false;
					break;
				}
				else
				{
					//number may be prime, but we need to iterate the checker.
					divisorPrimeIndex++;
					divisorPrimeValue = primes.get(divisorPrimeIndex);
				}
			}
			if(isPrime)
			{
				//number is prime
				primes.add(thisNumberToCheck);
				if(thisNumberToCheck <= lessThanNumber)
				{
					primesSum += thisNumberToCheck;
				}
			}
			thisNumberToCheck++;
			divisorPrimeIndex = 1;
			divisorPrimeValue = primes.get(divisorPrimeIndex);
		}
		System.out.println(primes.toString());
		System.out.println(primesSum);
	}
}
