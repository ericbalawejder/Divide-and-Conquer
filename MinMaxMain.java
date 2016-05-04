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
		
		int linearMin = 0, linearMax = 0, divideConquerMin = 0, divideConquerMax = 0;
		int agreementCounter = 0;
		
		for (int i = 0; i < 10000; i++)
		{
			int[] reference = Arrays.createRandomArray(arrayRandom, 10, 90);
			int[] linearResult = MM2Linear.minmax2Linear(reference);
			int[] dacResult = MM2DaC.minmax2DaC(reference);
			
			if (java.util.Arrays.equals(linearResult, dacResult))
			{
//				Arrays.print(reference, 16);
//				System.out.println();
//				java.util.Arrays.sort(reference);
//				Arrays.print(reference, 16);
//				System.out.println("Bogues results ");
//				Arrays.print(linearResult);
//				Arrays.print(dacResult);
				agreementCounter++;
			}
			
			// for special case first loop entry
			if  (i == 0)
			{
				linearMin = MM2Linear.counter;
				linearMax = MM2Linear.counter;
				divideConquerMin = MM2DaC.counter;
				divideConquerMax = MM2DaC.counter;
			}
			
			if (MM2Linear.counter < linearMin)
			{
				linearMin =  MM2Linear.counter;
			}
			
			if (MM2Linear.counter > linearMax)
			{
				linearMax = MM2Linear.counter;
			}
			
			if (MM2DaC.counter < divideConquerMin)
			{
				divideConquerMin = MM2DaC.counter;
			}
			
			if (MM2DaC.counter > divideConquerMax)
			{
				divideConquerMax = MM2DaC.counter;
			}
		}
		
		System.out.println("=========================================================================");
		// print range of values
		System.out.println("Range of numbers for linear algorithm (n = " + n + "): " + linearMin + ".." + linearMax);
		System.out.println("Range of numbers for divide and conquer algorithm (n = " + n + "): " + divideConquerMin + ".." + divideConquerMax);
		System.out.println("The two algorithms were compared 10000 times. They agreed in " + agreementCounter + " cases.");
	}
}
