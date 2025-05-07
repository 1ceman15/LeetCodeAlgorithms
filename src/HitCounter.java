
//https://leetcode.ca/2016-11-26-362-Design-Hit-Counter/


import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    private Queue<Integer> hits;

    public HitCounter(){
        hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        hits.offer(timestamp);
    }

    public int getHits(int timestamp){
        int startTime = timestamp - 3000;

        while (hits.isEmpty() && hits.peek() <= startTime){
            hits.poll();
        }

        return hits.size();
    }
}
