from typing import List
class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        # Initialize distance adjacency matrix
        distance = [[0 if i == j else float('inf') for j in range(n)] for i in range(n)]
        
        # Fill distance adjacency matrix with given information from edges
        for edge in edges:
            from_city, to_city, dist = edge
            distance[from_city][to_city] = dist
            distance[to_city][from_city] = dist
        
        # Apply Floyd-Warshall algorithm to find shortest paths from each city to all other cities
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if distance[i][k] != float('inf') and distance[k][j] != float('inf'):
                        distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])
        
        connects_under_threshold = n
        result = -1
        
     
        for i in range(n):
            num = 0
            for j in range(n):
                if distance[i][j] != 0 and distance[i][j] <= distanceThreshold:
                    num += 1
            
            if num <= connects_under_threshold:
                connects_under_threshold = num
                result = i
        
        return result

