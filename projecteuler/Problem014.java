package projecteuler;

import java.util.ArrayList;

public class Problem014 
{
	public static void main(String[] args)
	{
		int currentLargestCollatzNumber = 1;
		int currentLargestCollatzHolder = 1;
		for(int counter = 1; counter < 1000000; counter++)
		{
			double loopNumber = counter;
			ArrayList<Double> currentList = new ArrayList<Double>();
			while(loopNumber != 1)
			{
				currentList.add(loopNumber);
				if(loopNumber % 2 == 0)
				{
					loopNumber /= 2;
				}
				else
				{
					loopNumber = 3 * loopNumber + 1;
				}
			}
			if(currentList.size() > currentLargestCollatzNumber)
			{
				currentLargestCollatzHolder = counter;
				currentLargestCollatzNumber = currentList.size();
			}
			//System.out.println(counter + " " + currentList.size() + " " + currentLargestCollatzNumber);
		}
		System.out.println(currentLargestCollatzHolder + " " + currentLargestCollatzNumber);
	}
}
