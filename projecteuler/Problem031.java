package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem031 {
	public static void main(String[] args) {
		final int numberToSumTo = 200;
		final List<Integer> valuesToUse = Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1);
		System.out.println(numberOfWaysToSum(numberToSumTo,valuesToUse));
	}
	public static int numberOfWaysToSum(int numToSumTo, List<Integer> valuesCanSum){
		if(valuesCanSum.size() == 1)//base case
		{
			Integer thisValue = valuesCanSum.get(0);
			if(numToSumTo % thisValue == 0)//if you can get to the remaining sum number using only this number, then there is exactly one unique set doing so.
				return 1;
			else//if you can't evenly get to the remaining sum number, you can't do it at all.
				return 0;
		}
		else//we wish to drill down to the baser cases.
		{
			List<Integer> valuesCanSumCopy = new ArrayList<Integer>(valuesCanSum);//deep copy so we don't ruin shit.
			Integer thisValue = valuesCanSumCopy.remove(0);
			int waysToSum = 0;
			for(int thisValueCounter = 0; thisValueCounter * thisValue <= numToSumTo; thisValueCounter++)
			{
				waysToSum += numberOfWaysToSum(numToSumTo - thisValueCounter * thisValue, valuesCanSumCopy);
			}
			return waysToSum;
		}
	}
}
