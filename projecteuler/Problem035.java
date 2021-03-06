package projecteuler;

public class Problem035 {
	public static void main(String[] args){
		int numCircPrimes = 0;
		for(int c = 2; c < 1000000; c++){
			if(Lib.isPrime(c)){
				boolean isCircPrime = true;
				int cRotate = rotateNumber(c);
				while(c != cRotate){
					if(!Lib.isPrime(cRotate)){
						isCircPrime = false;
						break;
					}
					cRotate = rotateNumber(cRotate);
				}
				if(isCircPrime)
					numCircPrimes++;
			}
		}
		System.out.println(numCircPrimes);
	}
	
	public static int rotateNumber(int n){
		String strungNum = Integer.toString(n);
		String newNum = strungNum.charAt(strungNum.length() - 1) + strungNum.substring(0, strungNum.length() - 1);
		int newN = Integer.parseInt(newNum);
		return newN;
	}
}
