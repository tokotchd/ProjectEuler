package projecteuler;

import java.math.BigInteger;

public class Problem016 
{
	public static void main(String[] args)
	{
		double sizeCheck = Math.pow(2, 50);//no accuracy lost.
		BigInteger product = new BigInteger("1");
		BigInteger twoToFiftieth = new BigInteger("1125899906842624");//2^50 as a string without exponents.
		for(int counter = 0; counter < 1000/50; counter++)
		{
			product = product.multiply(twoToFiftieth);
		}
		String numbers = product.toString();
		System.out.println(numbers);
		double sum = 0;
		for(int counter = 0; counter < numbers.length(); counter++)
		{
			sum += Integer.parseInt(numbers.substring(counter,counter+1));
		}
		System.out.println(sum);
	}
}
