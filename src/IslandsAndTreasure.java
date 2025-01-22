
//https://neetcode.io/problems/islands-and-treasure

import java.util.LinkedList;
import java.util.Queue;

public class IslandsAndTreasure {
    public final int[][] COORDS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        if (q.size() == 0) return;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] coor : COORDS) {
                int r = cur[0] + coor[0];
                int c = cur[1] + coor[1];

                if (c < 0 || r < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != Integer.MAX_VALUE)
                    continue;

                q.add(new int[]{r, c});
                grid[r][c] = grid[cur[0]][cur[1]] + 1;
            }


        }


    }
}
