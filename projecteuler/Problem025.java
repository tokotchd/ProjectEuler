package projecteuler;

import java.math.BigInteger;

public class Problem025 
{
	public static void main(String[] args)
	{
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("1");
		int index = 2;
		BigInteger f3;
		//System.out.println("1:" + f1.toString());
		while(f2.toString().length() < 1000)
		{
			//System.out.println(index + ":" + f2.toString());
			f3 = f1.add(f2);
			f1 = new BigInteger(f2.toString());
			f2 = new BigInteger(f3.toString());
			index++;
		}
		System.out.println(index + ":" + f2.toString());
	}
}
