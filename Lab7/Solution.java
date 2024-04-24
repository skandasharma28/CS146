package Lab7;

public class Solution 
{
	public int findTheCity(int n, int[][] edges, int distanceThreshold)
	{
		
		int [][] distance = new int [n][n];
		
		//Fill distance adj.matrix w with 0's or infinity 
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if( i == j)
				{
					distance[i][j] = 0;
				}
				else
				{
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		//Fill distance adj matrix with given information from edges
		
		for(int i = 0; i < edges.length; i++)
		{
			int from = edges[i][0];
			int to = edges[i][1];
			int dist = edges[i][2];
			
			distance[from][to] = dist;
			distance[to][from] = dist;
		}
			
		// Apply Floyd-Warshall algorithm to find shortest paths from each of cities to all the other cities
		
		for (int k = 0; k < n; k++) 
		{
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) 
                    {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
		
		int connectsUnderThreshHold = distance.length;
		int result = -1;
		
		//Check reachable cities for each city 
        // Assign the city which has smallest # of reachable cities to result(which will be returned)
		
		for(int i = 0; i < distance.length; i++)
		{
			int num = 0;
			for(int j = 0; j < distance[0].length; j++)
			{
				if(distance[i][j] != 0 && distance[i][j] <= distanceThreshold) //Checks from city i to all the cities if distance is reachable, ignores itself
				{
					num ++;
				}
			}
			
			if( num <= connectsUnderThreshHold)
			{
				connectsUnderThreshHold = num; //Updates minReach if i has less reachable cities than previous cities
				result = i;
				
			}
		
		}
		
		return result;
	}

}
