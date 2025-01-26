import java.util.Comparator;
import java.util.PriorityQueue;


//[10, 12, 4, 6]
//[9, 11, 3, 5]
//[1, 7, 13, 8]
//[2, 0, 15, 14]

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        q.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (r == n - 1 && c == n - 1)
                return time;
            for (int[] dir : directions) {
                int x = r + dir[0];
                int y = c + dir[1];
                if (x >= 0 && y >= 0 && x < n && y < n && !visited[x][y]) {
                    q.offer(new int[]{Math.max(time, grid[x][y]), x, y});
                    visited[x][y] = true;
                }
            }

        }


        return 0;
    }
}
