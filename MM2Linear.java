package com.ebalawejder.MinMax2;

public class MM2Linear 
{
	static int counter = 0;
	
	public static void main(String[] args) 
	{
		// array of size 2^k, k a natural number
		final int n = 64;
		int[] arrayRandom = new int[n];

		// initialize the arrayRandom[] with random values 10..99
		for (int i = 0; i < n; i++) 
		{
			// a <= x < a + b
			arrayRandom[i] = 10 + (int) (Math.random() * 90);
		}
		
		// print the array with 16 elements per line
		print(arrayRandom, 16);

		// call minmax2Linear on the array of random values, size = 64
		// and create a reference to it
		int[] reference = minmax2Linear(arrayRandom);
		
		// print the fourArray returned from minmax2Linear() method
		for (int value : reference) 
		{
			System.out.print(value + " ");
		}
		
		System.out.println("\nNumber of comparisons = " + counter);
	}

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

	// array print method with added number per line feature
	public static void print(int[] array, int numberPerLine) 
	{
		for (int i = 0; i < array.length; i++) 
		{
			if (i != 0 && i % numberPerLine == 0) 
			{
				System.out.println();
			}
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
