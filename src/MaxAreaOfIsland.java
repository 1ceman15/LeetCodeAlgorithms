import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaOfIsland {
    boolean[][] visited;
    int[][] coords = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    int max = 0;

    public int maxAreaOfIsland(int[][] grid) {
        //visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(max, bfs_recursively(grid, i, j));
            }
        }

        return max;
    }


    public int bfs_recursively(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 )
            return 0;

        int result = 1;
        grid[i][j] = 0;

        result += bfs_recursively(grid, i + 1, j);
        result += bfs_recursively(grid, i - 1, j);
        result += bfs_recursively(grid, i, j - 1);
        result += bfs_recursively(grid, i, j + 1);

        return  result;


    }

    public void bfs(int[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j] = true;
        int sum = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            sum++;
            for (int[] coord : coords) {
                int x1 = x + coord[0];
                int y1 = y + coord[1];
                if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == 1 && !visited[x1][y1]) {
                    q.add(new int[]{x1, y1});
                    visited[x1][y1] = true;
                }
            }


        }
        max = Math.max(sum, max);

    }
}
