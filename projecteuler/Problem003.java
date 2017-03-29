package projecteuler;

public class Problem003 
{
	public static void main(String[] args)
	{
		double toFactor = 8462696833d;
		for(int counter = 0; counter < Lib.primes.length; counter++)
		{
			if(toFactor%Lib.primes[counter]==0)
			{
				System.out.println(Lib.primes[counter]);
			}
		}
	}
}
