//https://leetcode.com/problems/redundant-connection/


public class RedundantConnection {
    int[] parents;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for(int[] edge: edges){
            if(!union(edge[0],edge[1]))
                return edge;
        }
        return new int[0];
    }

    public int find(int node) {
        int p = parents[node];

        while (p != parents[p]) {
            parents[p] = parents[parents[p]];
            p = parents[p];
        }

        return p;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 == p2)
            return false;

        if (rank[p1] > rank[p2]) {
            parents[p2] = p1;
            rank[p2]++;
        } else {
            parents[p1] = p2;
            rank[p2]++;
        }

        return true;
    }
}
