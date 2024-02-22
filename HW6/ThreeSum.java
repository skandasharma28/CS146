package Hw6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
     //This step helps skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) 
            {
                continue;
            }

            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < nums.length; j++) {
                int comp = target - nums[j];

                if (map.containsKey(comp)) {
                	returnList.add(Arrays.asList(nums[i], comp, nums[j]));

                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                        j++;
                    }
                }

                map.put(nums[j], j);
            }
        }

        return returnList;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {-1,1,2};
        int [] biggerNums = {-10,10,0,0,5,-5};
        List<List<Integer>> result = test.threeSum(nums);
        List<List<Integer>> result2 = test.threeSum(biggerNums);
        System.out.println(result);
        System.out.println(result2);
    }
    
}
