
//https://leetcode.ca/2017-03-31-487-Max-Consecutive-Ones-II/


public class MaxConsecutiveOnes2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int zeros = 0;
        int left = 0;

        for(int i = 0; i < nums.length; i++){
           if(nums[i] == 0){
               zeros++;
           }
           if(zeros > 1){
              while (left <nums.length && zeros > 1){
                  if(nums[left] == 0){
                      zeros--;
                  }
                  left++;
              }
           }
           maxOnes = Math.max(maxOnes, i - left +1 );
        }

        maxOnes = Math.max(maxOnes, nums.length - left +1 );

        return maxOnes;
    }


}
