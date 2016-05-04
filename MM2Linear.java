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
		
		int[] reference = {10, 61, 13, 42, 36, 45, 21, 49, 74, 94, 69, 52, 29, 75, 73, 37, 
				56, 46, 66, 17, 93, 85, 80, 86, 84, 19, 46, 44, 52, 26, 98, 79, 
				26, 38, 87, 40, 27, 64, 14, 52, 14, 51, 55, 60, 16, 69, 24, 27, 
				35, 95, 43, 16, 26, 81, 78, 95, 89, 18, 33, 15, 55, 20, 63, 96 };

		// fill arrayRandom[] with random values from the range 10..99 with the
		// createRandomArray() method and create a reference to it
		//int[] reference = Arrays.createRandomArray(arrayRandom, 10, 90);

		// print the array with 16 elements per line
		Arrays.print(reference, 16);
		System.out.println();
	

		// call minmax2Linear on the array of random values and show the four array
		Arrays.print(minmax2Linear(reference));
		System.out.println();
		java.util.Arrays.sort(reference);
		Arrays.print(reference, 16);
		System.out.println();
		// show the number of comparisons
		System.out.println("Number of comparisons = " + counter);
	}
	
	// minmax2Linear() finds the 2 least and 2 greatest elements of an array
	public static int[] minmax2Linear(int[] array) 
	{
		int[] fourArray = new int[4];
		counter = 0;
		
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max1 = Integer.MIN_VALUE;

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
		fourArray[0] = min1;
		fourArray[1] = min2;
		fourArray[2] = max2;
		fourArray[3] = max1;

		return fourArray;
	}
}
