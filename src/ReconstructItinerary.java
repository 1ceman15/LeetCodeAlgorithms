
//https://leetcode.com/problems/reconstruct-itinerary/description/

import java.util.*;

//Hierholzer's Algorithm (предназначен для нахождения Эйлерова пути)
//Эйлеров путь — это путь в графе,
// который проходит по каждому ребру графа ровно один раз.
// При этом вершины могут посещаться несколько раз,
// но рёбра нельзя пересекать более одного раза.
public class ReconstructItinerary {
    List<String> result = new ArrayList<>();
    HashMap<String, PriorityQueue<String>> nei = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket: tickets){
            nei.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        dfs( "JFK");

        Collections.reverse(result);
        return result;
    }
    public void dfs(String src){
        PriorityQueue<String> q = nei.get(src);
        while (q != null && !q.isEmpty()){
            String d = q.poll();
            dfs(d);
        }
        result.add(src);
    }

}
