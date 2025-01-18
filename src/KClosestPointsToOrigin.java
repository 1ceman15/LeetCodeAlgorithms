//https://leetcode.com/problems/k-closest-points-to-origin/description/


import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> q = new PriorityQueue<>((a, b) -> Double.compare(a[0], b[0]));
        int[][] answer = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            double distance = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            q.add(new double[]{distance, i});
        }
        for (int i = 0; i < k; i++) {
            answer[i] = points[(int)q.poll()[1]];
        }


        return answer;
    }




}
