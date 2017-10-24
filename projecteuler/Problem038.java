package projecteuler;

public class Problem038 {
	public static void main(String[] args){
		double currentMax = -1;
		for(int i = 1; i <= 99999; i++)
		{
			String thisCat = largestConcatenatedProduct(i);
			if(Problem032.isStringPandigital(thisCat)){
				double thisFatCat = Double.parseDouble(thisCat);
				currentMax = Math.max(thisFatCat, currentMax);
			}
		}
		System.out.println(currentMax);
	}
	public static String concatenatedProduct(int base, int... sequence){
		String baseStr = "";
		for(int thisScalar: sequence){
			baseStr += "" + (base * thisScalar);
		}
		return baseStr;
	}
	public static String largestConcatenatedProduct(int base){
		String largestSoFar = "-1";
		for(int i = 2; i <= 9; i++){
			int[] currentArray = new int[i];
			for(int j = 0; j < currentArray.length; j++)
				currentArray[j] = j+1;
			String currentCatProduct = concatenatedProduct(base, currentArray);
			if(Double.parseDouble(currentCatProduct) > 987654321)
				break;
			else
				largestSoFar = currentCatProduct;
		}
		return largestSoFar;
	}
}
