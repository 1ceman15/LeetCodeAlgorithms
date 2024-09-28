
//https://leetcode.com/problems/maximum-product-subarray/description/

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int result = nums[0];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n: nums) {
            if(n == 0){
                max = 1;
                min = 1;
            }
            int temp = max*n;
            max = Math.max(Math.max(min*n,max*n),n);
            min = Math.min(Math.min(min*n, temp),n);

            result = Math.max(result,max);

        }

        return result;

    }

    public int maxProduct2(int[] nums) {
        int max = -11;
        int n = nums.length;
        int prod=1;

        for(int i=0;i<n;i++)
        {
            prod*=nums[i];
            max=Math.max(prod,max);
            if(prod==0)
                prod=1;
        }
        prod=1;
        for(int i=n-1;i>=0;i--)
        {
            prod*=nums[i];

            max=Math.max(prod,max);
            if(prod==0)
                prod=1;
        }
        return max;
    }


}
