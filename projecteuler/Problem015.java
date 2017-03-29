package projecteuler;

public class Problem015 
{
	/*	
	turned it into a n choose k combinatorics problem.
	Firstoff, we know there are a total of 2*n decisions, down or right.
	But we also know in order to end up at the end, there has to be n downs and n rights for each combination.
	So we start with a summation of n+1 terms (from 0 to n inclusive).  
	Each term of that summation is a product of two n choose k values.  
	For each term in that summation of cardinality n+1, call it m:
	The first productee represents the number of downs (WLOG) done in the first n decisions.  
	Since there are n decisions and m possibilities to go down, the number of possibilities is n choose m.
	The second productee represents the number of downs (WLOG) done in the second n decisions.
	Since we know that we choose to do m downs (WLOG) in the first n steps, we know the second n steps must have n-m downs.
	So that term is (n-m) choose m
	
	An example for n = 2:
	
	m = 0 	| 		2d in 2 spaces			|	2r in 2 spaces 		| 	(2 choose 0)*(2 choose 2) = 1
	m = 1 	|	 	1d, 1r in 2 spaces		|	1d, 1r in 2 spaces 	| 	(2 choose 1)*(2 choose 1) = 4
	m = 2 	| 		2r in 2 spaces			|	2d in 2 spaces		| 	(2 choose 2)*(2 choose 0) = 1
	
	So there are 6 ways when n = 2
	
	
	An example for n = 3:
	
	m = 0 	|		3d in 3 spaces			| 	3r in 3 spaces		| 	(3 choose 0)*(3 choose 3) = 1
	m = 1 	| 		2d, 1r in 3 spaces		| 	1d, 2r in 3 spaces	|	(3 choose 2)*(3 choose 1) = 9
	m = 2	|		1d, 2r in 3 spaces		|	2d, 1r in 3 spaces	| 	(3 choose 1)*(3 choose 2) = 9
	m = 3	|		3r in 3 spaces			| 	3d in 3 spaces		|	(3 choose 3)*(3 choose 0) = 1
	
	there are 20 ways for n = 3
	
	COINCIDENTALLY THIS IS (2N CHOOSE N)!!!
	
	*/
	public static void main(String[] args)
	{
		final int NUMBER_OF_ROWS = 20;
		double summation = 0;
		for(int counter = 0; counter <= NUMBER_OF_ROWS; counter++)
		{
			double firstTerm = Lib.nChooseK(NUMBER_OF_ROWS, counter);
			double secondTerm = Lib.nChooseK(NUMBER_OF_ROWS, NUMBER_OF_ROWS-counter);
			summation += (firstTerm * secondTerm);
		}
		System.out.println(summation);
		System.out.println(Lib.nChooseK(40, 20));
	}
	
}
