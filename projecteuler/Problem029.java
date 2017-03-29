package projecteuler;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem029 
{
	public static void main(String[] args)
	{
		//this one is slightly slower.  Maybe Hashmap optimizes hash lookups?  I guess it must because that's how hashes work (ordered sequence mapping)
		//I guess if we implemented this as a sorted list and did a binary search, we could  speed this up?
//		ArrayList<Double> table = new ArrayList<Double>();
//		for(int a = 2; a <= 100; a++)
//		{
//			for(int b = 2; b <= 100; b++)
//			{
//				double index = Math.pow(a, b);
//				if(!table.contains(index))
//					table.add(index);
//			}
//		}
//		System.out.println(table.size());
		
		HashMap<Double, Boolean> hashy = new HashMap<Double, Boolean>();
		for(int a = 2; a <= 100; a++)
		{
			for(int b = 2; b <= 100; b++)
			{
				double index = Math.pow(a, b);
				hashy.putIfAbsent(index, true);
			}
		}
		System.out.println(hashy.values().size());
	}
}
