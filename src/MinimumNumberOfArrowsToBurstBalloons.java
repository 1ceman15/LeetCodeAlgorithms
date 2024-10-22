
//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/


import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {

        int answer = 1;

        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int left = points[0][0];
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
            left = Math.max(left, points[i][0]);
            right = Math.min(right, points[i][1]);
            if (left > right) {
                answer++;
                left = points[i][0];
                right = points[i][1];
            }

        }


        return answer;

    }

}
