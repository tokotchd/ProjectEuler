package projecteuler;

import java.math.BigInteger;

public class Problem020 
{
	public static void main(String[] args)
	{
		BigInteger bigInt = new BigInteger("1");
		for(int counter = 1; counter <= 100; counter++)
		{
			bigInt = bigInt.multiply(new BigInteger(Integer.toString(counter)));
		}
		String strungInt = bigInt.toString();
		int sum = 0;
		for(int counter = 0; counter < strungInt.length(); counter++)
		{
			sum += Integer.parseInt(strungInt.substring(counter,counter+1));
		}
		System.out.println(sum);
	}
}
