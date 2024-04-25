package Hw12;

import java.util.Arrays;

public class ConnectingHouses 
{
	 public int minCostToSupplyWater(int n, int[] wells, int[][] pipes)
	 {
		  int[][] costs = new int [n + 1][n + 1];
		  
		  for(int i = 0; i <= n; i++)
		  {
			  for(int j = 0; j <= n; j++ )
			  {
				  
					 costs[i][j] = Integer.MAX_VALUE; 
				 
			  }
		  }
		  //Connection between 0 to the house# = cost of building a well
		  for(int i = 1; i <= wells.length; i++)
		  {
			  costs[0][i] = wells[i-1];
			  costs[i][0] = wells[i-1];
		  }
		  
		  for(int[] pipe: pipes)
		  {
			  int from = pipe[0];
			  int to = pipe[1];
			  int cost = pipe[2];
			  
			  if(costs[from][to] > cost || costs[to][from] > cost)//Ignores if it has a better cost already
			  {
				  costs[from][to] = cost;
				  costs[to][from] = cost;
			  }
		  }
		  
		  return prims(costs);
		  
	 }
	 
	 private int prims(int[][] costs) {
	        int n = costs.length;
	        boolean[] visited = new boolean[n];
	        int[] minCost = new int[n];
	        Arrays.fill(minCost, Integer.MAX_VALUE);
	        minCost[0] = 0;

	        int totalCost = 0;

	        for (int i = 0; i < n; i++) {
	            int minVertex = -1;

	           
	            for (int j = 0; j < n; j++) {
	                if (!visited[j] && (minVertex == -1 || minCost[j] < minCost[minVertex])) 
	                {
	                    minVertex = j;
	                }
	            }

	            
	            if (minVertex == -1) 
	            {
	                break;
	            }

	            
	            visited[minVertex] = true;
	            totalCost += minCost[minVertex];

	            
	            for (int j = 0; j < n; j++)
	            {
	                if (costs[minVertex][j] != Integer.MAX_VALUE && !visited[j] && costs[minVertex][j] < minCost[j]) {
	                    minCost[j] = costs[minVertex][j];
	                }
	            }
	        }

	        return totalCost;
	    }
}
