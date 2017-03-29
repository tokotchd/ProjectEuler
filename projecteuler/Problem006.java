package projecteuler;

public class Problem006 
{
	public static void main(String[] args)
	{
		double sum = 0;
		double sumSquared = 0;
		double squaredSum = 0;
		for(int counter = 1; counter <= 100; counter++)
		{
			sum += counter;
			squaredSum += Math.pow(counter, 2);
		}
		sumSquared = Math.pow(sum, 2);
		System.out.printf("%.1f", sumSquared-squaredSum);
	}
}
