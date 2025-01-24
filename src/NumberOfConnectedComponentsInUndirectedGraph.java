import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://neetcode.io/problems/count-connected-components
public class NumberOfConnectedComponentsInUndirectedGraph {
    HashSet<Integer> visited = new HashSet<>();
    List<List<Integer>> adj = new ArrayList<>();
    public int countComponents(int n, int[][] edges) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }

        for (int i = 0; i < n; i++) {
            if(!visited.contains(i)) {
                dfs(i);
                answer++;
            }
        }


        return answer;

    }

    public void dfs(int node){
        visited.add(node);
        for (int nei: adj.get(node)) {
            if(!visited.contains(nei))
                dfs(nei);
        }


    }



}
