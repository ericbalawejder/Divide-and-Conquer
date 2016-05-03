package com.ebalawejder.MinMax2;

public class MM2DaC 
{
	static int counter;
	
	public static void main(String[] args) 
	{
//		int[] sample1 = {15,111,36,2};
//		int[] sample2 = {200,1,6,23};
//		Arrays.print(minmax2Four(sample1));
//		Arrays.print(minmax2Four(sample2));
//		
//		Arrays.print(merge(sample1, sample2));
		
		// array of size 2^k, k a natural number
		final int n = 64;
		int[] arrayRandom = new int[n];
		int[] reference = Arrays.createRandomArray(arrayRandom, 10, 90);
		
		// print the array with 16 elements per line
		Arrays.print(reference, 16);
		int[] result = minmax2DaC(reference);
		System.out.println();
		java.util.Arrays.sort(reference);
		Arrays.print(reference, 16);
		System.out.println();
		Arrays.print(result);
		System.out.println(counter);
	}

	public static int[] minmax2DaC(int[] array)
	{
		counter = 0;
		return toFourArray(array);
	}

	public static int[] toFourArray(int[] array) 
	{
		int[][] arrays = Arrays.arraySplit(array);
		int[] left = arrays[0];
		int[] right = arrays[1];
		
		return toFourArrayRecursion(left, right);
	}
	
	public static int[] toFourArrayRecursion(int[] left, int[] right)
	{
		if (left.length == 4 && right.length == 4)
		{
			return merge(left, right);
		}

		int[] mergedLeft = toFourArray(left); 
		int[] mergedRight = toFourArray(right);
		return toFourArrayRecursion(mergedLeft, mergedRight);		
	}
	
	public static int[] merge(int[] array1, int[] array2)
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
		// return four array with two smallest and two largest elements
		return fourArray;
	}
	
	public static int[] minmax2Four(int[] array)
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
			counter++;
			min1 = a;
			min2 = b;
		}
		else
		{
			counter++;
			min1 = b;
			min2 = a;
		}
		// compare second two elements
		if (c < d)
		{
			counter++;
			max2 = c;
			max1 = d;
		}
		else 
		{
			counter++;
			max2 = d;
			max1 = c;
		}
		// compare first and third element
		if (min1 < max2)
		{
			counter++;
			a = min1;
			c = max2;
		}
		else
		{
			counter++;
			a = max2;
			c = min1;
		}
		// compare second and fourth element
		if (min2 < max1)
		{
			counter++;
			b = min2;
			d = max1;
		}
		else
		{
			counter++;
			b = max1;
			d = min2;
		}
		// compare second and third element
		if (b > c)
		{
			counter++;
			// swap b and c
			int temp = c;
			c = b;
			b = temp;
		}
		else
		{
			counter++;
		}
		
		fourArray[0] = a;
		fourArray[1] = b;
		fourArray[2] = c;
		fourArray[3] = d;
		
		return fourArray;
	}
}
