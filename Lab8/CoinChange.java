package Lab8;

import java.util.Arrays;

public class CoinChange 
{
    public int coinChange(int[] coins, int amount) {
        // Create a 2D array to store the minimum number of coins needed for each amount using denominations
        int[][] Tabulation2d = new int[coins.length + 1][amount + 1];

        // Initialize the first column to be 0 
        for (int i = 0; i <= coins.length; i++) {
            Tabulation2d[i][0] = 0;
        }

        // Initialize the first row to amount + 1
        for (int j = 1; j <= amount; j++)
        {
            Tabulation2d[0][j] = amount + 1;
        }

        // Fill the Tabulation2d array
        for (int i = 1; i <= coins.length; i++)
        {
            for (int j = 1; j <= amount; j++)
            {
                if (coins[i - 1] > j)
                {
                    Tabulation2d[i][j] = Tabulation2d[i - 1][j];
                } else 
                {
                    
                    Tabulation2d[i][j] = Math.min(Tabulation2d[i - 1][j], Tabulation2d[i][j - coins[i - 1]] + 1);
                }
            }
        }

        
        if (Tabulation2d[coins.length][amount] <= amount) 
        {
            return Tabulation2d[coins.length][amount];
        } 
        else
        {
            return -1;
        }
    }

}
