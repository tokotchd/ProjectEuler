package projecteuler;

public class Problem019 
{
	public static void main(String[] args)
	{
		int dayCounter; //mod 7 where: 0 = sunday, 1 = monday, 2 = tuesday, 3 = wednesday, 4 = thursday, 5 = friday, 6 = saturday.
		
		int sundaysOnFirstOfTheMonthCounter = 0;//the number of Sundays that occurred on the first of the month so far.
		dayCounter = 1;//Jan 1st, 1990 was monday.
		
		for(int year = 1900; year <= 2000; year++)
		{
			for(int month = 1; month <= 12; month++)
			{
				if(dayCounter == 0 && year != 1990)//stupid gimmick
				{
					sundaysOnFirstOfTheMonthCounter++;
					System.out.println(month + "/1st/" + year + " was a Sunday!");
				}
				dayCounter = (dayCounter + numberOfDaysInMonthYear(month,year)) % 7;
			}
		}
		
		System.out.println(sundaysOnFirstOfTheMonthCounter);
		
	}
	private static int numberOfDaysInMonthYear(int month, int year)
	{
		if(month == 2)//Feb and leap years
		{
			if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))//every 4 years *except* for centuries *except* for every 4 centuries
			{
				return 29;
			}
			else
			{
				return 28;
			}
		}
		else if(month == 9 || month == 6 || month == 4 || month == 11)
		{
			return 30;
		}
		else
		{
			return 31;
		}
	}
}
