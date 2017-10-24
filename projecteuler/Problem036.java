package projecteuler;

public class Problem036 {
	public static void main(String[] args){
		int sum = 0;
		for(int counter = 0; counter < 1000000; counter++){
			if(isPalindrome(Integer.toString(counter)) && isPalindrome(Integer.toBinaryString(counter)))
				sum+=counter;
		}
		System.out.println(sum);
	}
	public static boolean isPalindrome(String s){
		String newS = "";
		for(int counter = s.length() -1; counter >= 0; counter--){
			newS += s.charAt(counter);
		}
		return s.equals(newS);
	}
}
