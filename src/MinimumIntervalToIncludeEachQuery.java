import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        HashMap<Integer, Integer> hm = new HashMap<>();

        int index = 0;
        for(int query: Arrays.stream(queries).sorted().toArray()){
            while (index < intervals.length && intervals[index][0] <= query){
                pq.add(new int[]{(intervals[index][1] - intervals[index][0] + 1), intervals[index][1]});
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < query){
                pq.poll();
            }
            if(pq.isEmpty()){
                hm.put(query, -1);
            }else {
                hm.put(query, pq.peek()[0]);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = hm.get(queries[i]);
        }

        return queries;

    }
}
