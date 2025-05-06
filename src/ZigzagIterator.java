
//https://leetcode.ca/2016-09-06-281-Zigzag-Iterator/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    Queue<Integer> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2){
        buildQueue(v1, v2);
    }


    public boolean hasNext(){
        return !queue.isEmpty();
    }

    public int next(){
        return queue.poll();
    }

    private void buildQueue(List<Integer> v1, List<Integer> v2){
        int index1 = 0;
        int index2 = 0;

        while (index1 < v1.size() && index2 < v2.size()){
            queue.offer(v1.get(index1++));
            queue.offer(v2.get(index2++));
        }

        while (index1 < v1.size()){
            queue.offer(v1.get(index1++));
        }

        while (index2 < v2.size()){
            queue.offer(v2.get(index2++));
        }

    }

}
