package projecteuler;

public class Problem037 {
	public static void main(String[] args){
		int sum = 0;
		for(int n = 10; n <= 1000000; n++){
			if(Lib.isPrime(n)){
				if(isLeftToRightTruncatablePrime(n) && isRightToLeftTruncatablePrime(n)){
					sum += n;
				}
			}
		}
		System.out.println(sum);
	}
	public static boolean isLeftToRightTruncatablePrime(int number){
		boolean thisNumberPrime = Lib.isPrime(number);
		String thisNumber = Integer.toString(number);
		if(thisNumber.length() == 1)
			return thisNumberPrime;
		String nextNumber = thisNumber.substring(1);
		int nextNum = Integer.parseInt(nextNumber);
		return thisNumberPrime && isLeftToRightTruncatablePrime(nextNum);
	}
	public static boolean isRightToLeftTruncatablePrime(int number){
		boolean thisNumberPrime = Lib.isPrime(number);
		String thisNumber = Integer.toString(number);
		if(thisNumber.length() == 1)
			return thisNumberPrime;
		String nextNumber = thisNumber.substring(0,thisNumber.length() - 1);
		int nextNum = Integer.parseInt(nextNumber);
		return thisNumberPrime && isRightToLeftTruncatablePrime(nextNum);
	}
}
