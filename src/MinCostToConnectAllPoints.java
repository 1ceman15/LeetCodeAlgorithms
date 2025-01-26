
//https://leetcode.com/problems/min-cost-to-connect-all-points/description/

import java.util.Arrays;

public class MinCostToConnectAllPoints {
    public static int minCostConnectPoints(int[][] points) {
        int N = points.length;
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];
        int result = 0;
        int edges = 0;

        Arrays.fill(dist, Integer.MAX_VALUE);

        int node = 0;

        while (edges < N -1){
            visited[node] = true;
            int nextNode = -1;
            for (int i = 0; i < N; i++) {
                if(visited[i])
                    continue;

                int curDist = Math.abs(points[i][0] - points[node][0]) +
                        Math.abs(points[i][1] - points[node][1]);

                dist[i] = Math.min(dist[i], curDist);
                if(nextNode == -1 || dist[i] < dist[nextNode]){
                    nextNode = i;
                }
            }
            result += dist[nextNode];
            edges++;
            node = nextNode;
        }


        return result;
    }

}
