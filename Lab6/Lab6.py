from typing import List
from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adjacency_list = [[] for _ in range(numCourses)]
        in_degree = [0] * numCourses
        topological_order = []

        for course, prerequisite in prerequisites:
            adjacency_list[prerequisite].append(course)
            in_degree[course] += 1

        queue = deque()
        for i in range(numCourses):
            if in_degree[i] == 0:
                queue.append(i)

        while queue:
            current_course = queue.popleft()
            topological_order.append(current_course)

            for next_course in adjacency_list[current_course]:
                in_degree[next_course] -= 1
                if in_degree[next_course] == 0:
                    queue.append(next_course)

        return len(topological_order) == numCourses

