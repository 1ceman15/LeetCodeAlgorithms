//https://leetcode.com/problems/last-stone-weight/description/

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone: stones) {
            q.offer(stone);
        }

        while (q.size() > 1){
            int stoneOne  = q.poll();
            int stoneTwo = q.poll();
            if(stoneOne > stoneTwo){
                q.offer(stoneOne - stoneTwo);
            } else if (stoneOne < stoneTwo) {
                q.offer(stoneTwo - stoneOne);
            }

        }

        return q.size() > 0 ? q.poll(): 0;

    }
}
