import java.util.HashMap;

public class CountSubarraysWithMedianK {
    public int countSubarrays(int[] nums, int k) {
        int posIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                posIndex = i;
                break;
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int balance = 0;

        for (int i = posIndex - 1; i >= 0; i--) {
            if (nums[i] < k) balance--;
            if (nums[i] > k) balance++;

            hm.put(balance, hm.getOrDefault(balance, 0) + 1);

        }


        int count = 0;
        balance = 0;
        for (int i = posIndex; i < nums.length; i++) {
            if (nums[i] < k) balance--;
            if (nums[i] > k) balance++;

            count += hm.getOrDefault(-balance, 0);
            count += hm.getOrDefault(-balance + 1, 0);
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithMedianK sol = new CountSubarraysWithMedianK();
        System.out.println(sol.countSubarrays(new int[]{3, 2, 1, 4, 5}, 4)); // Выводит 3
    }
}
