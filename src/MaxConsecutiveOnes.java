
//https://leetcode.com/problems/max-consecutive-ones/description/

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int onesCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                onesCount++;
            }else{
                maxOnes = Math.max(maxOnes, onesCount);
                onesCount = 0;

            }
        }
        maxOnes = Math.max(maxOnes, onesCount);
        return maxOnes;
    }
}
