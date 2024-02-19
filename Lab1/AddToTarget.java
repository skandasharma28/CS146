package Lab1;

import java.util.Arrays;

public class AddToTarget 
{
	public static int[] addUp(int[] nums, int target)
	{
		int [] returnArray = new int[2];
		
		for(int i = 0; i< nums.length; i++)
		{
			for (int j = i + 1; j < nums.length; j++)
			{
				if(nums[i] + nums[j]== target)
				{
					returnArray[0] = i;
					returnArray[1] = j;
					return returnArray;
				}
			}
		}
		return returnArray;
	}
	
	public static void main(String [] args)
	{
		int [] nums ={0,1,2,3,4,5};
		int target = 8;
		int [] result = addUp(nums, target);
		
		System.out.println(Arrays.toString(result));	
	}

}



