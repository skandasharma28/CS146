import sys

class ConnectingHouses:
    def minCostToSupplyWater(self, n, wells, pipes):
        # Initialize the adjacency matrix with infinite costs
        costs = [[sys.maxsize] * (n + 1) for _ in range(n + 1)]
        
        # Connection between 0 to the house# = cost of building a well
        for i in range(1, n + 1):
            costs[0][i] = wells[i - 1]
            costs[i][0] = wells[i - 1]
        
        # Update the adjacency matrix with costs from pipes
        for pipe in pipes:
            from_house, to_house, cost = pipe
            if costs[from_house][to_house] > cost or costs[to_house][from_house] > cost:
                costs[from_house][to_house] = cost
                costs[to_house][from_house] = cost
        
        return self.prims(costs)
    
    def prims(self, costs):
        n = len(costs)
        visited = [False] * n
        min_cost = [sys.maxsize] * n
        min_cost[0] = 0
        total_cost = 0
        
        for _ in range(n):
            min_vertex = -1
            for j in range(n):
                if not visited[j] and (min_vertex == -1 or min_cost[j] < min_cost[min_vertex]):
                    min_vertex = j
            
            if min_vertex == -1:
                break
            
            visited[min_vertex] = True
            total_cost += min_cost[min_vertex]
            
            for j in range(n):
                if costs[min_vertex][j] != sys.maxsize and not visited[j] and costs[min_vertex][j] < min_cost[j]:
                    min_cost[j] = costs[min_vertex][j]
        
        return total_cost
