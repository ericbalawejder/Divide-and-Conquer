package com.ebalawejder.MinMax2;

public class MinMaxMain 
{
	public static void main(String[] args) 
	{
		final int n = 64;
		int[] arrayRandom = new int[n];
		
		// Display the random array, the four arrays found, and the 
		// number of comparisons made for both the linear and divide 
		// and conquer algorithms. Repeat this 5 times
		for (int i = 0; i < 5; i++)
		{
			// create a reference to an array of random values 10..99
			int[] reference = 
					Arrays.createRandomArray(arrayRandom, 10, 90);
			System.out.println("The random array of 64 elements are:");
			Arrays.print(reference, 16);
			System.out.println();
			System.out.print("\tMinMax2 using the Linear Algorithm: ");
			Arrays.print(MM2Linear.minmax2Linear(reference));
			System.out.println("\tNumber of comparisons made: " + 
					MM2Linear.counter);
			System.out.println();
			System.out.print("\tMinMax2 using the Divide and " +
					"Conquer Algorithm: ");
			Arrays.print(MM2DaC.minmax2DaC(reference));
			System.out.println("\tNumber of comparisons made: " + 
					MM2DaC.counter);
			System.out.println("\n");
		}
		
		int linearMin = 0, linearMax = 0, divideConquerMin = 0, 
				divideConquerMax = 0;
		
		// counter to test if both four arrays are the same
		int agreementCounter = 0;
		
		
		
		
		// run 10000 times and compare both algorithms
		for (int i = 0; i < 10000; i++)
		{
			int[] reference = 
					Arrays.createRandomArray(arrayRandom, 10, 90);
			int[] linearResult = MM2Linear.minmax2Linear(reference);
			int[] dacResult = MM2DaC.minmax2DaC(reference);
			
			// if the four arrays are equal, increase the counter
			if (java.util.Arrays.equals(linearResult, dacResult))
			{
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
			// record the min counter value from MMLinear
			if (MM2Linear.counter < linearMin)
			{
				linearMin =  MM2Linear.counter;
			}
			// record the max counter value from MMLinear
			if (MM2Linear.counter > linearMax)
			{
				linearMax = MM2Linear.counter;
			}
			// record the min counter value from MM2DaC
			if (MM2DaC.counter < divideConquerMin)
			{
				divideConquerMin = MM2DaC.counter;
			}
			// record the max counter value from MM2DaC
			if (MM2DaC.counter > divideConquerMax)
			{
				divideConquerMax = MM2DaC.counter;
			}
		}
		
		System.out.println("=======================================" +
				"==================================");
		// print range of values
		System.out.println("Range of numbers for linear algorithm " +
				"(n = " + n + "): " + linearMin + ".." + linearMax);
		System.out.println("Range of numbers for divide and conquer " +
				"algorithm (n = " + n + "): " + divideConquerMin + 
				".." + divideConquerMax);
		System.out.println("The two algorithms were compared " +
				"10000 times. " + "They agreed in " + 
				agreementCounter + " cases.");
	}
}