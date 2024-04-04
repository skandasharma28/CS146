package Lab6;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class CoursePreReqs {
    public boolean canFinish(int numCourses, int[][] preReqs) {
        List<Integer>[] adjacencyList = new List[numCourses];
        int[] inDegree = new int[numCourses];
        List<Integer> toplogicalOrder = new ArrayList<>();

        for (int[] p : preReqs) {
            int course = p[0];
            int preReq = p[1];
            if (adjacencyList[preReq] == null) 
            {
                adjacencyList[preReq] = new ArrayList<>();
            }
            adjacencyList[preReq].add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            toplogicalOrder.add(currentCourse);

            if (adjacencyList[currentCourse] != null) {
                for (int nextCourse : adjacencyList[currentCourse]) {
                    inDegree[nextCourse]--;
                    if (inDegree[nextCourse] == 0) {
                        queue.offer(nextCourse);
                    }
                }
            }
        }

        return toplogicalOrder.size() == numCourses;
    }
}
