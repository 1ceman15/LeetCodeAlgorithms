
//https://leetcode.com/problems/hand-of-straights/description/

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(hand);
        for(int num: hand){
            if(count.getOrDefault(num,0) > 0){
                for (int i = num; i < num + groupSize; i++) {
                    if(count.getOrDefault(i,0) <= 0) return false;
                    count.put(i, count.get(i) -1);
                }
            }
        }





        return true;
    }


}
