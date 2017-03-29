package projecteuler;

public class Problem024 
{
	private static final String START_STRING = "0123456789";
	private static String currentString = START_STRING;
	
	public static void main(String[] args)
	{
		int currentIndex = 1;
		while(currentIndex < 1000000)
		{
			currentString = iterateString(currentString);
			currentIndex++;
		}
		System.out.print(currentIndex + ":");
		System.out.println(currentString);
	}
	
	private static String iterateString(String currentString)
	{
		for(int indexSecond = currentString.length() - 1; indexSecond >= 1; indexSecond--)
		{
			int indexFirst = indexSecond - 1;
			char charSecond = currentString.charAt(indexSecond);
			char charFirst = currentString.charAt(indexFirst);
			if(charFirst < charSecond)
			{
				//to go faster, the base case of the last two is just a swap.
				if(indexSecond == currentString.length() - 1)
				{
					currentString = currentString.substring(0, currentString.length() - 2) + charSecond + charFirst;
					break;
				}
				else
				{
					String subStringNotIncludingHead = currentString.substring(indexSecond,currentString.length());
					int oldHead = Character.getNumericValue(currentString.charAt(indexFirst));
					int newHead = getMinGreaterThan(subStringNotIncludingHead, oldHead);
					//go through the string without the head and replace the newhead's value with oldhead.
					subStringNotIncludingHead = subStringNotIncludingHead.replace((char)(newHead + 48), (char)(oldHead + 48));
					subStringNotIncludingHead = subStrFlip(subStringNotIncludingHead);
					currentString = currentString.substring(0, indexFirst);//chop off the tail.
					currentString += newHead;
					currentString += subStringNotIncludingHead;
					
					break;
				}
			}
		}
		return currentString;
	}
	
	private static int getMinGreaterThan(String substring, int oldHead) 
	{
		int currentMin = Integer.MAX_VALUE;
		for(int counter = 0; counter < substring.length(); counter++)
		{
			int thisVal = Character.getNumericValue(substring.charAt(counter));
			if(thisVal > oldHead && thisVal < currentMin)
				currentMin = thisVal;
		}
		return currentMin;
	}
	private static String subStrFlip(String subString)
	{
		String returnString = "";
		for(int counter = subString.length() - 1; counter >= 0; counter--)
		{
			returnString+=subString.charAt(counter);
		}
		return returnString;
	}
}
