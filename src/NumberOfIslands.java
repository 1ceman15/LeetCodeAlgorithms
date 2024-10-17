
//https://leetcode.com/problems/number-of-islands/description/


import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    boolean[][] visited;

    int[][] coords = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        int answer = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(grid,i,j);
                    answer++;
                }


            }
        }

        return answer;
    }

    public void bfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int[] coord : coords) {
                int x1 = x + coord[0];
                int y1 = y + coord[1];
                if(x1>= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == '1' && !visited[x1][y1]) {
                    q.add(new int[]{x1, y1});
                    visited[x1][y1] = true;
                }
            }


        }

    }



    public void bfs_recursively(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }else if(visited[i][j] || grid[i][j] == '0' ) {
            return;
        } else {
            visited[i][j] = true;
            for(int[] coord : coords) {
                int x1 = i + coord[0];
                int y1 = j + coord[1];
                bfs_recursively(grid,x1,y1);
            }
        }


    }

}
