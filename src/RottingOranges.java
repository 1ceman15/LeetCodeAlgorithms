import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/description/
public class RottingOranges {
    public final int[][] COORDS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;
        int time = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    fresh++;
                if (grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty() && fresh > 0) {

            int length = q.size();
            for (int i = 0; i < length; i++) {
                int[] cur = q.poll();
                for (int[] coord : COORDS) {
                    int r = cur[0] + coord[0];
                    int c = cur[1] + coord[1];

                    if (c < 0 || r < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != 1)
                        continue;

                    grid[r][c] = 2;
                    fresh--;
                    q.add(new int[]{r, c});
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;

    }
}
