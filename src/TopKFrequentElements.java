
//https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {


        int[] answer = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int number : bucket[i]) {
                answer[index++] = number;
                if (index >= k) {
                    return answer;
                }
            }

        }


        return answer;
    }
}
