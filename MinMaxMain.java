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
			System.out.print("\tMinMax2 using the Divide and Conquer Algorithm: ");
			Arrays.print(MM2DaC.minmax2DaC(reference));
			System.out.println("\tNumber of comparisons made: " + MM2DaC.counter);
			System.out.println("\n");
		}
		
		int linearMin = -1, linearMax = -1, divideConquerMin = -1, divideConquerMax = -1;
		
		for (int i = 0; i < 10000; i++)
		{
			int[] reference = Arrays.createRandomArray(arrayRandom, 10, 90);
			MM2Linear.minmax2Linear(reference);
			MM2DaC.minmax2DaC(reference);
			
			// for special case first loop entry
			if ( linearMin == -1)
			{
				linearMin = MM2Linear.counter;
			}
			else if (MM2Linear.counter < linearMin)
			{
				linearMin =  MM2Linear.counter;
			}
			
			if (linearMax == -1)
			{
				linearMax = MM2Linear.counter;
			}
			else if (MM2Linear.counter > linearMax)
			{
				linearMax = MM2Linear.counter;
			}
			
			if (divideConquerMin == -1)
			{
				divideConquerMin = MM2DaC.counter;
			}
			else if (MM2DaC.counter < divideConquerMin)
			{
				divideConquerMin = MM2DaC.counter;
			}
			
			if (divideConquerMax == -1)
			{
				divideConquerMax = MM2DaC.counter;
			}
			else if (MM2DaC.counter > divideConquerMax)
			{
				divideConquerMax = MM2DaC.counter;
			}
		}
		
		System.out.println("===================================================");
		// print range of values
		System.out.println("Range of numbers for linear algorithm (n = " + n + "): " + linearMin + ".." + linearMax);
		System.out.println("Range of numbers for divide and conquer algorithm (n = " + n + "): " + divideConquerMin + ".." + divideConquerMax);
	}
}
