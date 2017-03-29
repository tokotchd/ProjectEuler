package projecteuler;

public class Problem028 
{
	//n = 1		n = 3		n = 5			n = 7
	//n-1=0		n-1 = 2		n-1 = 4			n-1 = 6
	//1			3,5,7,9		13,17,21,25		31,37,43,49...
	public static void main(String[] args)
	{
		final int numOfRowsAndColumns = 1001;
		long sum = 1;
		int currentInt = 1;
		for(int counter = 3; counter <= numOfRowsAndColumns; counter+=2)
		{
			for(int c = 0; c < 4; c++)
			{
				sum += currentInt += (counter-1);
			}
		}
		System.out.println(sum);
	}
}
