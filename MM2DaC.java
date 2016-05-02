package com.ebalawejder.MinMax2;

public class MM2DaC 
{
	public static void main(String[] args) 
	{
		int[] sample1 = {15,111,36,2};
		int[] sample2 = {200,1,6,23};
		Arrays.print(minmax2Four(sample1));
		Arrays.print(minmax2Four(sample2));
		
		Arrays.print(merge(sample1, sample2));
	}

	private static int[] minmax2DaC(int[] array)
	{
		int[] fourArray = new int[4];
		return fourArray;
	}
	
	private static int[] merge(int[] array1, int[] array2)
	{
		int[] fourArray = new int[4];
		
		int[] fourArray1 = minmax2Four(array1);
		int[] fourArray2 = minmax2Four(array2);
		
		// smallest two elements from both four arrays
		if (fourArray1[0] < fourArray2[0])
		{
			fourArray[0] = fourArray1[0];
			if (fourArray2[0] < fourArray1[1])
			{
				fourArray[1] = fourArray2[0];
			}
			else 
			{
				fourArray[1] = fourArray1[1];
			}
		}
		else
		{
			fourArray[0] = fourArray2[0];
			if (fourArray1[0] < fourArray2[1])
			{
				fourArray[1] = fourArray1[0];
			}
			else
			{
				fourArray[1] = fourArray2[1];
			}
		}
		
		// largest two elements from both four arrays
		if (fourArray1[3] > fourArray2[3])
		{
			fourArray[3] = fourArray1[3];
			if (fourArray2[3] > fourArray1[2])
			{
				fourArray[2] = fourArray2[3];
			}
			else
			{
				fourArray[2] = fourArray1[2];
			}
		}
		else
		{
			fourArray[3] = fourArray2[3];
			if (fourArray1[3] > fourArray2[2])
			{
				fourArray[2] = fourArray1[3];
			}
			else
			{
				fourArray[2] = fourArray2[2];
			}
		}
		
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
		
		// compare first two elements
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
		// compare second two elements
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
		// compare first and third element
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
		// compare second and fourth element
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
		// compare second and third element
		if (b > c)
		{
			// swap b and c
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
