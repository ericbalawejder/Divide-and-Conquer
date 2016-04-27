package com.ebalawejder.MinMax2;

public class MM2Linear 
{
	public static void main(String[] args) 
	{
		// array of size 2^k, k a natural number
		// values 10..99 
		int[] list = {123,19,64,73,23,89,44,51,61};
		
		int[] reference = min(list);
	    for (int value : reference)
	    {
	        System.out.print(value + " ");
	    }
	}
	
	private static int[] minmax2Linear(int[] array)
	{
		int[] fourArray = new int[4];
		return fourArray;
	}
	
	private static int[] min(int[] array) 
	{
		int[] fourArray = new int[4];
		
		int min1 = array[0];
		int min2 = array[0];
        int max2 = array[0];
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
            	min1 = array[i];
            }
//            else if (array[i] )
//            {
//            	
//            }
        }
        fourArray[0] = min1;
        //fourArray[1] = min2;
        fourArray[2] = max2;
        fourArray[3] = max1;
        
        return fourArray;
    }
}
