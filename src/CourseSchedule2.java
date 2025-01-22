import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/submissions/1516955246/
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> hm = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            hm.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites){
            inDegree[pre[1]]++;
            hm.get(pre[0]).add(pre[1]);
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }
        int finished = 0;

        int[] output = new int[numCourses];
        while (!q.isEmpty()){
            int course = q.poll();
            output[numCourses- finished -1] = course;
            finished++;
                for (int nei : hm.get(course)){
                    inDegree[nei]--;
                    if(inDegree[nei] == 0)
                        q.add(nei);

                }
        }


        return finished == numCourses? output: new int[0];


    }

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int[] order = new int[numCourses];
//        int[] inDegree = new int[numCourses];
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        Queue<Integer> queue = new LinkedList<>();
//        // Initialize the graph
//        for (int[] pre : prerequisites) {
//            int target = pre[0], preCourse = pre[1];
//            map.computeIfAbsent(preCourse, k -> new ArrayList<>()).add(target);
//            inDegree[target] += 1;
//        }
//        // Find all courses with no prerequisites
//        for (int i = 0; i < numCourses; ++i) {
//            if (inDegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//        int index = 0;
//        while (!queue.isEmpty()) {
//            int node = queue.poll();
//            order[index++] = node;
//
//            if (map.containsKey(node)) {
//                for (int target : map.get(node)) {
//                    inDegree[target] -= 1;
//                    if (inDegree[target] == 0) {
//                        queue.offer(target);
//                    }
//                }
//            }
//        }
//        return index == numCourses ? order : new int[0];
//    }
}
