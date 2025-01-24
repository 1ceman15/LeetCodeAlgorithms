import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//https://neetcode.io/problems/valid-tree
public class GraphValidTree {
    HashSet<Integer> visited = new HashSet<>();
    List<List<Integer>> adj = new ArrayList<>();

    public boolean validTree(int n, int[][] edges) {

        if (edges.length < n - 1)
            return false;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);

        }

        if (!dfs(0, -1))
            return false;

        return visited.size() == n;


    }

    public boolean dfs(int node, int parent) {
        if (visited.contains(node))
            return false;

        visited.add(node);
        for (int nei : adj.get(node)) {
            if (nei == parent)
                continue;
            if (!dfs(nei, node))
                return false;
        }

        return true;


    }
}
