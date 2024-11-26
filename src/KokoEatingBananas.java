
//https://leetcode.com/problems/koko-eating-bananas/description/

import java.util.Arrays;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int answer = 0;
        while (left <= right) {
            int k = (right + left) / 2;
            long total = 0;
            for(int pile : piles) {
                total += Math.ceil((double) pile / k);

            }
            if(total <= h) {
                answer = k;
                right = k - 1;
            }
            else {
                left = k + 1;
            }

        }

        return answer;

    }


}
