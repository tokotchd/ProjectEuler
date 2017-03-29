package projecteuler;
import java.util.Arrays;

public class Problem008 
{
	public static void main(String[] args)
	{
		int adjacentDigits = 13;
		
		String bigAssNumber = "73167176531330624919225119674426574742355349194934969835203127745063262395783180169848018694788518438586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557668966489504452445231617318564030987111217223831136222989342338030813533627661428280644448664523874970172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		double largestProduct = 0;
		int[] largestSerial = null;
		
		double currentProduct;
		int[] currentSerial;
		for(int currentStart = 0; currentStart < bigAssNumber.length() - (adjacentDigits); currentStart++)
		{
			currentSerial = new int[adjacentDigits];
			currentProduct = 1;
			for(int currentCounter = 0; currentCounter < adjacentDigits; currentCounter++)
			{
				currentSerial[currentCounter] = Integer.parseInt(Character.toString(bigAssNumber.charAt(currentStart + currentCounter)));
				currentProduct*=currentSerial[currentCounter];
			}
			if(currentProduct > largestProduct)
			{
				largestProduct = currentProduct;
				largestSerial = currentSerial.clone();
			}
		}
		System.out.println("Largest Serial : " + Arrays.toString(largestSerial));
		System.out.printf("Largest Product : %.0f", largestProduct);
	}
}
