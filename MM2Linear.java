package com.ebalawejder.MinMax2;

public class MM2Linear 
{
	public static void main(String[] args) 
	{
		// array of size 2^k, k a natural number, values 10..99

		final int n = 64;
		int[] arrayRandom = new int[n];

		for (int i = 0; i < n; i++) 
		{
			// a <= x < a + b
			arrayRandom[i] = 10 + (int) (Math.random() * 90);
		}

		print(arrayRandom, 16);

		// print the fourArray returned from minmax2Linear() method
		int[] reference = minmax2Linear(arrayRandom);
		for (int value : reference) 
		{
			System.out.print(value + " ");
		}
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
				max2 = max1;
				max1 = array[i];
			} 
			else if (array[i] > max2) 
			{
				max2 = array[i];
			} 
			else if (array[i] < min1) 
			{
				min2 = min1;
				min1 = array[i];
			} 
			else if (array[i] < min2) 
			{
				min2 = array[i];
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
