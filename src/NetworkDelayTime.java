import java.util.*;

//https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelayTime {

    //Сигнал от начального узла идет во все соседние параллельно
    public static int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> neighbors = new HashMap();
        for (int[] time : times) {
            neighbors.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        q.add(new int[]{0, k});
        HashSet<Integer> visited = new HashSet<>();
        int result = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int key = now[1];
            int time = now[0];
            if (visited.contains(key))
                continue;

            visited.add(key);

            result = time;

            if (neighbors.containsKey(key)) {
                for (int[] nei : neighbors.get(key)) {
                    if (!visited.contains(nei)) {
                        q.add(new int[]{time + nei[1], nei[0]});
                    }
                }


            }

        }


        return visited.size() == n ? result : -1;
    }

}
