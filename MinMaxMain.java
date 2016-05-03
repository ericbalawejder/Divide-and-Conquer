package com.ebalawejder.MinMax2;

public class MinMaxMain 
{
	public static void main(String[] args) 
	{
		final int n = 64;
		int[] arrayRandom = new int[n];
		
		// Display the random array, the four arrays found, and the number of
		// comparisons made for both the linear and divide and conquer algorithms.
		// Repeat this 5 times
		for (int i = 0; i < 5; i++)
		{
			int[] reference = Arrays.createRandomArray(arrayRandom, 10, 90);
			System.out.println("The random array of 64 elements are:");
			Arrays.print(reference, 16);
			
			System.out.println();
			
			System.out.print("\tMinMax2 using the Linear Algorithm: ");
			Arrays.print(MM2Linear.minmax2Linear(reference));
			System.out.println("\tNumber of comparisons made: " + MM2Linear.counter);
			System.out.println();
			System.out.println("\tMinMax2 using the Divide and Conquer Algorithm: ");
			System.out.println("\tNumber of comparisons made: ");
			System.out.println("\n");
		}
	}
}
