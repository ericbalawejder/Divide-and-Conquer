package com.ebalawejder.MinMax2;

public class Arrays 
{
	// array print method with added number per line feature
	public static void print(int[] array, int numberPerLine) 
	{
		for (int i = 0; i < array.length; i++) 
		{
			if (i != 0 && i % numberPerLine == 0) 
			{
				System.out.println();
			}
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}

	// array print method
	public static void print(int[] array) 
	{
		for (int i = 0; i < array.length; i++) 
		{
			System.out.print(array[i] + "  ");
		}
		System.out.println();
	}

	// method to fill an array with random values from the range a <= x < (a + b)
	public static int[] createRandomArray(int[] array, int a, int b) 
	{
		for (int i = 0; i < array.length; i++) 
		{
			array[i] = a + (int) (Math.random() * b);
		}
		return array;
	}
	
	// method to bisect an array in halves keeping the elements intact.
	// returns an array with both array halves
	public static int[][] arraySplit(int[] array)
	{
		int[] array1 = new int[array.length/2];
		int[] array2 = new int[array.length/2];
		
		for (int i = 0; i < array.length/2; i++)
		{
			array1[i] = array[i];
		}
		
		for (int i = 0; i < array.length/2; i++)
		{
			array2[i] = array[array.length/2 + i];
		}
		
		int[][] arrays = {array1, array2};
		
		return arrays;
	}
}
