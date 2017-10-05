package projecteuler;

public class Problem034 {
	public static void main(String[] args){
		for(int counter = 0; counter <= 2540161; counter++){
			String thisNumber = Integer.toString(counter);
			double thisFactorialSum = 0;
			for(Character digit: thisNumber.toCharArray()){
				thisFactorialSum += Lib.factorial(Character.getNumericValue(digit));
			}
			if(thisFactorialSum == counter)
				System.out.println(thisNumber);
		}
	}
}
