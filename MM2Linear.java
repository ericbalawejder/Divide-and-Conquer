package com.ebalawejder.MinMax2;

public class MM2Linear 
{
	// class variable to count the number of comparisons in 
	// minmax2Linear algorithm. Initializes to 0 by default
	static int counter;

	// linear algorithm finds the 2 least and 2 greatest 
	// elements of an array
	public static int[] minmax2Linear(int[] array) 
	{
		int[] fourArray = new int[4];
		
		// reset counter to 0 each time method is called
		counter = 0;
		
		// initialize to arbitrary values to avoid special 
		// cases in comparisons
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max1 = Integer.MIN_VALUE;

		// loop through the array once and find the least 
		// two and greatest two elements
		for (int i = 0; i < array.length; i++) 
		{
			if (array[i] > max1) 
			{
				counter++;
				max2 = max1;
				max1 = array[i];
			} 
			else if (array[i] > max2) 
			{
				counter += 2;
				max2 = array[i];
			} 
			else
			{
				counter += 2;
			}
			if (array[i] < min1) 
			{
				counter++;
				min2 = min1;
				min1 = array[i];
			} 
			else if (array[i] < min2) 
			{
				counter += 2;
				min2 = array[i];
			} 
			else 
			{
				counter += 2;
			}
		}
		// assign values to four array
		fourArray[0] = min1;
		fourArray[1] = min2;
		fourArray[2] = max2;
		fourArray[3] = max1;

		return fourArray;
	}
}