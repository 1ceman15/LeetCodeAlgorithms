import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] answer = new int[nums.length-k+1];
        int l = 0;
        int r = 0;

        while (r < nums.length){
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r])
                deque.removeLast();

            deque.add(r);

            if(l > deque.peekFirst())
                deque.removeFirst();


            if((r+1) >= k) {
                answer[l++] = nums[deque.getFirst()];
            }
            r++;
        }

        return answer;
    }
}
