package projecteuler;

public class Problem005 
{
	public static void main(String[] args)
	{
		boolean found = false;
		for(int counter = 1; counter < Integer.MAX_VALUE; counter++)
		{
			for(int counter2 = 1; counter2 <= 20; counter2++)
			{
				if(counter % counter2 == 0)
				{
					if(counter2 == 20)
						found = true;
				}
				else
				{
					break;
				}
			}
			if(found)
			{
				System.out.println(counter);
				break;
			}
		}
	}
}
