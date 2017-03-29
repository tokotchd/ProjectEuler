package projecteuler;

public class Problem017 
{
	public static void main(String[] args)
	{
		double sumOfAllLetters = 0;
		for(int counter = 1; counter <= 1000; counter++)
		{
			int thisNumbersLetters = 0;
			String strungCounter = Integer.toString(counter);
			
			//prefix for easy pasring.
			while(strungCounter.length() < 4)
			{
				strungCounter = "0" + strungCounter;
			}
			int thousands = Integer.parseInt(strungCounter.substring(0,1));
			int hundreds = Integer.parseInt(strungCounter.substring(1,2));
			int tens = Integer.parseInt(strungCounter.substring(2,3));
			int ones = Integer.parseInt(strungCounter.substring(3,4));
			
			//thousands
			if(thousands != 0)
			{
				thisNumbersLetters = getBaseNumberSize(thousands);//we add the base number size
				thisNumbersLetters += 8;//for the word "thousand"
				if(hundreds == 0 && (tens != 0 || ones != 0))//accounting for "and" if hundreds is blank, but ones and thousands are not.
				{
					thisNumbersLetters += 3;
				}
			}
			
			//hundreds
			if(hundreds != 0)
			{
				thisNumbersLetters = getBaseNumberSize(hundreds);//base number size
				thisNumbersLetters += 7;//for the word "hundred"
				if(tens != 0 || ones != 0)//accounting for "and" if hundreds is ones and thousands are not blank
				{
					thisNumbersLetters += 3;
				}
			}
			
			if(tens != 0)//Ninety(6), Eighty(6), Seventy(7), Sixty(5), Fifty(5), Forty(5), Thirty(6), Twenty(6).
			{
				if(tens == 9 || tens == 8 || tens == 3 || tens == 2)
				{
					thisNumbersLetters += 6;
					thisNumbersLetters += getBaseNumberSize(ones);//base ones size.
				}
				else if(tens == 7)
				{
					thisNumbersLetters += 7;
					thisNumbersLetters += getBaseNumberSize(ones);//base ones size.
				}
				else if(tens == 6 || tens == 5 || tens == 4)
				{
					thisNumbersLetters += 5;
					thisNumbersLetters += getBaseNumberSize(ones);//base ones size.
				}
				else if(tens == 0)
				{
					//thisNumbersLetters += 0;
					thisNumbersLetters += getBaseNumberSize(ones);
				}
				else//things get problematic around here Teens(???)
				{
					//Ten(3), Eleven(6), Twelve(6), Thirteen(8), Fourteen(8), Fifteen(7), Sixteen(7), Seventeen(9), Eighteen(8), Nineteen(8)
					if(ones == 1 || ones == 2)
						thisNumbersLetters += 6;
					else if(ones == 5 || ones == 6)
						thisNumbersLetters += 7;
					else if(ones == 3 || ones == 4 || ones == 8 || ones == 9)
						thisNumbersLetters += 8;
					else if(ones == 7)
						thisNumbersLetters += 9;
					else
						thisNumbersLetters += 3;//zero in ones, or ten;
				}
			}
			else//if tens is zero, we just add base number size.
			{
				thisNumbersLetters += getBaseNumberSize(ones);
			}
			sumOfAllLetters += thisNumbersLetters;
		}
		System.out.println(sumOfAllLetters);
	}
	public static int getBaseNumberSize(int num)
	{
		if(num == 1 || num == 2 || num == 6)
			return 3;
		else if(num == 4 || num == 5 || num == 9)
			return 4;
		else if(num == 3 || num == 7 || num == 8)
			return 5;
		else //0, we never pronounce  zero.
			return 0;
	}
}
