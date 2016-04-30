package com.ebalawejder.MinMax2;

public class MM2DaC 
{
	public static void main(String[] args) 
	{
		int[] sample = {15,11,36,13};
		Arrays.print(minmax2Four(sample));
	}

	private static int[] minmax2DaC(int[] array)
	{
		int[] fourArray = new int[4];
		return fourArray;
	}
	
	private static int[] minmax2Four(int[] array)
	{
		int[] fourArray = new int[4];
		
		int min1, min2, max2, max1;
		
		int a = array[0];
		int b = array[1];
		int c = array[2];
		int d = array[3];
		
		if (a < b)
		{
			min1 = a;
			min2 = b;
		}
		else
		{
			min1 = b;
			min2 = a;
		}
		if (c < d)
		{
			max2 = c;
			max1 = d;
		}
		else 
		{
			max2 = d;
			max1 = c;
		}
		if (min1 < max2)
		{
			a = min1;
			c = max2;
		}
		else
		{
			a = max2;
			c = min1;
		}
		if (min2 < max1)
		{
			b = min2;
			d = max1;
		}
		else
		{
			b = max1;
			d = min2;
		}
		if (b > c)
		{
			int temp = c;
			c = b;
			b = temp;
		}
		
		fourArray[0] = a;
		fourArray[1] = b;
		fourArray[2] = c;
		fourArray[3] = d;
		
		return fourArray;
	}
}
