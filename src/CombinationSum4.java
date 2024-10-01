
//https://leetcode.com/problems/combination-sum-iv/description/


import java.util.Arrays;
import java.util.HashMap;

public class CombinationSum4 {
    public static int combinationSum4(int[] nums, int target) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);

        for (int i = 1; i <= target; i++) {
            hm.put(i, 0);
            for (int num : nums) {
                hm.put(i, hm.get(i) + (hm.containsKey(i-num)? hm.get(i-num):0));
            }

        }
        return hm.get(target);

    }


    public int combinationSum4_2(int[] arr, int k) {
        int[] dp = new int[k + 1];
        Arrays.fill(dp,-1);
        return dfs(arr,k,dp);
    }

    public int dfs(int[] arr,int k,int[] dp){
        if(k == 0){
            return 1;
        }
        if(k < 0){
            return 0;
        }
        if(dp[k] != -1){
            return dp[k];
        }
        int right = 0;
        for(int i = 0;i<arr.length;i++){
            right += dfs(arr,k - arr[i],dp);
        }
        return dp[k] = right;
    }


}



