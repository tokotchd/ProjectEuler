package projecteuler;

import java.util.Arrays;
import java.util.List;

public class Problem032 {
	public static void main(String[] args){
		int sumOfProducts = 0;
		for(int thisProduct = 1; thisProduct < 100000; thisProduct++){
			for(int thisDivisor = 1; thisDivisor <= Math.sqrt(thisProduct); thisDivisor++){
				if(thisProduct % thisDivisor == 0){
					String stringToCheck = Integer.toString(thisProduct) + '=' + Integer.toString(thisDivisor) + '*' + Integer.toString(thisProduct/thisDivisor);
					if(isStringPandigital(stringToCheck)){
						sumOfProducts += thisProduct;
						System.out.println(stringToCheck);
						break;
					}
				}
			}
		}
		System.out.println(sumOfProducts);
	}
	final static List<Character> strungNumbers = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
	public static boolean isStringPandigital(String strungNumber){
		if(strungNumber.contains("0"))
			return false;
		for(Character number: strungNumbers)
			if(!containsExactlyOnce(strungNumber,number))
				return false;
		return true;
	}
	public static boolean containsExactlyOnce(String string, char subString){
		boolean hasAppeared = false;
		for(int counter = 0; counter < string.length(); counter++){
			if(string.charAt(counter) == subString){
				if(hasAppeared)
					return false;
				else
					hasAppeared = true;
			}
		}
		return hasAppeared;
	}
}
