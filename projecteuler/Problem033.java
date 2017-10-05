package projecteuler;

public class Problem033 {
	public static void main(String[] args){
		for(int x = 0; x <= 9; x++)
			for(int y = 0; y <= 9; y++)
				for(int z = 0; z <= 9; z++){
					int numerator = 10*x + y;
					int denominator = 10*y + z;
					if(((double)numerator / denominator) == (double)x/z)
						System.out.println(numerator + "/" + denominator);
				}
	}
}
