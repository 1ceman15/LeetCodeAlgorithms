public class MaxConsecutiveOnes3 {
    public  int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int zeros = 0;
        int left = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeros++;
            }
            if(zeros > k){
                while (left <nums.length && zeros > k){
                    if(nums[left] == 0){
                        zeros--;
                    }
                    left++;
                }
            }
            maxOnes = Math.max(maxOnes, i - left +1 );
        }

        maxOnes = Math.max(maxOnes, nums.length - left);

        return maxOnes;
    }


}
