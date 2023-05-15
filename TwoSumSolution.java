import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
class TwoSumSolution {
     
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> balanceMap = new HashMap<Integer, Integer>();
        for(int i = 0; i< nums.length; i++) balanceMap.put(nums[i], i);

       int[] result = new int[2];
       for(int i = 0; i < nums.length; i++) {
           
           Integer balanceIndex = balanceMap.get(target - nums[i]);
           
           if(balanceIndex == null || balanceIndex == i) continue;
           
           if( balanceIndex !=null) { 
               result[0] = i;
               result[1] = balanceIndex;
           }
       }
    return result;
    }
}

