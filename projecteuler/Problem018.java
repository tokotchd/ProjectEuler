package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem018 
{
	private static int[] bigArray = 
		{
			75,
			95,64,
			17,47,82,
			18,35,87,10,
			20,04,82,47,65,
			19,01,23,75,03,34,
			88,02,77,73,07,63,67,
			99,65,04,28,06,16,70,92,
			41,41,26,56,83,40,80,70,33,
			41,48,72,33,47,32,37,16,94,29,
			53,71,44,65,25,43,91,52,97,51,14,
			70,11,33,28,77,73,17,78,39,68,17,57,
			91,71,52,38,17,14,91,43,58,50,27,29,48,
			63,66,04,68,89,53,67,30,73,16,69,87,40,31,
			04,62,98,27,23,9,70,98,73,93,38,53,60,04,23//15 rows
		};
	public static void main(String[] args)
	{
		//Load Data
		ArrayList<int[]> rowList = new ArrayList<int[]>();
		int bigArrayCounter = 0;
		for(int row = 0; row < 15; row++)
		{
			int[] thisRow = new int[row+1];
			for(int column = 0; column < thisRow.length; column++)
			{
				thisRow[column] = bigArray[bigArrayCounter++];
			}
			rowList.add(thisRow);
		}
		
//		for(int counter = 0; counter < rowList.size(); counter++)
//		{
//			System.out.println(Arrays.toString(rowList.get(counter)));
//		}
		
		//Data loaded
		int currentRowToSumIndex = rowList.size() - 1;//start our row to sum on the bottom
		int[] currentRowToSum = rowList.get(currentRowToSumIndex);
		while(currentRowToSumIndex != 0)//until we get back to the root
		{
			int[] summationRow = rowList.get(currentRowToSumIndex - 1);//summation row is above current row to sum
			for(int column = 0; column < summationRow.length; column++)//for all of the above's columns,
			{
				int aboveNumber = summationRow[column];//get the "top" number
				int leftSum = currentRowToSum[column] + aboveNumber;//get the sum of the left and top
				int rightSum = currentRowToSum[column + 1] + aboveNumber;//get the sum of the right and top
				summationRow[column] = Math.max(leftSum, rightSum);//return the max of those two sums.
			}
			//once we've merged the summation rows, we bump em up
			currentRowToSum = summationRow;
			currentRowToSumIndex--;
		}
		System.out.println(Arrays.toString(currentRowToSum));
	}
	
}
