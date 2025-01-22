import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//https://leetcode.com/problems/course-schedule/description/

//Также можно решить через LinkedList<Integer>[]
//Добавить все курсы туда, и проверить все LinkedList на наличие цикла
//https://chatgpt.com/share/6790fbb7-5db4-8011-831a-fb4dd4cb07a6
public class CourseSchedule {
    HashSet<Integer> visited;
    HashMap<Integer, List<Integer>> hm;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hm = new HashMap<>();
        this.visited = new HashSet<>();

        for (int i = 0; i < numCourses; i++) {
            hm.put(i, new ArrayList<>());
        }

        for(int[] course: prerequisites){
            hm.get(course[0]).add(course[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i))
                return false;
        }

        return true;
    }

    public boolean dfs(int course){
        if(visited.contains(course))
            return false;

        if(hm.get(course).size() == 0)
            return true;

        visited.add(course);
        for(int pre: hm.get(course)) {
            if (!dfs(pre))
                return false;
        }
        visited.remove(course);
        hm.put(course, new ArrayList<>());

        return true;


    }
}
