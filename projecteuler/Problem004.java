package projecteuler;

public class Problem004 
{
	public static void main(String[] args)
	{
		int maxPal = 0;
		for(int counter = 999; counter > 0; counter--)
		{
			for(int counter2 = 999; counter2 > 0; counter2--)
			{
				int product = counter*counter2;
				if(isNumberPalindrome(product))
				{
					if(product > maxPal)
					{
						maxPal = product;
					}
				}
			}
		}
		System.out.println(maxPal);
	}
	
	public static boolean isNumberPalindrome(int numberToCheck)
	{
		String stringToCheck = Integer.toString(numberToCheck);
		return isStringPalindrome(stringToCheck);
	}
	public static boolean isStringPalindrome(String stringToCheck)
	{
		for(int counter = 0; counter < stringToCheck.length()/2; counter++)
		{
			if(stringToCheck.charAt(counter) != stringToCheck.charAt((stringToCheck.length()-counter)-1))
			{
				return false;
			}
		}
		return true;
	}
}
