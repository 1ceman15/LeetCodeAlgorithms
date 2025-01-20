import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.offer(num);
        if(small.size() - large.size() > 1 || !large.isEmpty() && large.peek() < small.peek())
            large.offer(small.poll());

        if(large.size() - small.size() > 1)
            small.offer(large.poll());
    }

    public double findMedian() {
        if(small.size() == large.size())
            return (double) (small.peek() + large.peek()) /2;
        else if(small.size() > large.size())
            return small.peek();
        else return large.peek();
    }
}
