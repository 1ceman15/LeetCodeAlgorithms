import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/problems/clone-graph/description/
public class CloneGraph {
    public Node cloneGraph(Node node) {


        HashMap<Node, Node> hm = new HashMap<>();
        return dfs(node, hm);
        //return bfs(node);
    }

    public Node bfs(Node node){
        if (node == null) return null;

        HashMap<Node, Node> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        hm.put(node, new Node(node.val));
        q.add(node);

        while (!q.isEmpty()){
            Node cur = q.poll();
            for(Node n: cur.neighbors){
                if(!hm.containsKey(n)){
                    hm.put(n, new Node(n.val));
                    q.add(n);
                }
                hm.get(cur).neighbors.add(hm.get(n));
            }
        }


        return hm.get(node);
    }
    public Node dfs(Node node, Map<Node, Node> hm){
        if(node == null)
            return null;

        if(hm.containsKey(node))
            return hm.get(node);

        Node copy = new Node(node.val);
        hm.put(node, copy);

        for (Node n: node.neighbors){
            copy.neighbors.add(dfs(n, hm));
        }


        return copy;

    }
}
