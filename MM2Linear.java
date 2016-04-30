package com.ebalawejder.MinMax2;

public class MM2Linear 
{
	// class variable to count the number of comparisons in minmax2Linear
	// algorithm. Initializes to 0 by default
	static int counter;

	public static void main(String[] args) 
	{
		// array of size 2^k, k a natural number
		final int n = 64;
		int[] arrayRandom = new int[n];

		// fill arrayRandom[] with random values from the range 10..99 with the
		// createRandomArray() method and create a reference to it
		int[] reference = Arrays.createRandomArray(arrayRandom, 10, 90);

		// print the array with 16 elements per line
		Arrays.print(reference, 16);

		// call minmax2Linear on the array of random values and show the four array
		Arrays.print(minmax2Linear(reference));

		// show the number of comparisons
		System.out.println("Number of comparisons = " + counter);
	}
	
	// minmax2Linear() finds the 2 least and 2 greatest elements of an array
	private static int[] minmax2Linear(int[] array) 
	{
		int[] fourArray = new int[4];

		int min1 = array[0];
		int min2 = array[1];
		int max2 = array[1];
		int max1 = array[0];

		for (int i = 1; i < array.length; i++) 
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
			else if (array[i] < min1) 
			{
				counter += 3;
				min2 = min1;
				min1 = array[i];
			} 
			else if (array[i] < min2) 
			{
				counter += 4;
				min2 = array[i];
			} 
			else 
			{
				counter += 5;
			}
		}
		fourArray[0] = min1;
		fourArray[1] = min2;
		fourArray[2] = max2;
		fourArray[3] = max1;

		return fourArray;
	}
}
