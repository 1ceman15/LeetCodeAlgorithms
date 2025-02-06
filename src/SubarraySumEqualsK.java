import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int needed = sum-k;

            answer+= hm.getOrDefault(needed,0);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }


        return answer;
    }
}
