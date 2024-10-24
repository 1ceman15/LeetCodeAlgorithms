
//https://leetcode.com/problems/pacific-atlantic-water-flow/


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PacificAtlanticOceanFlow {
    List<List<Integer>> answer = new ArrayList<>();

    final int[][] coords = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];


        for (int i = 0; i < heights[0].length; i++) {
            bfs(heights, pacific, 0, i, heights[0][i]);
            bfs(heights, atlantic, heights.length - 1, i, heights[heights.length - 1][i]);
        }


        for (int i = 0; i < heights.length; i++) {
            bfs(heights, pacific, i, 0, heights[i][0]);
            bfs(heights, atlantic, i, heights[0].length - 1, heights[i][heights[0].length - 1]);


        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    answer.add(Arrays.asList(j, i));
                }

            }
        }


        return answer;
    }


    public void bfs(int[][] heights, boolean[][] visited, int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[i].length || heights[i][j] < prev)
            return;


        if (visited[i][j])
            return;

        visited[i][j] = true;

        for (int[] coord : coords) {
            int x = coord[0] + i;
            int y = coord[1] + j;
            bfs(heights, visited, x, y, heights[i][j]);
        }


    }

}
