from typing import List

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        Tabulation2d = [amount + 1] * (amount + 1)
        Tabulation2d[0] = 0

        for coin in coins:
            for i in range(coin, amount + 1):
                Tabulation2d[i] = min(Tabulation2d[i], Tabulation2d[i - coin] + 1)

        return Tabulation2d[amount] if Tabulation2d[amount] <= amount else -1

# Tester
def main():
    solution = Solution()
    coins = [1,10,25,50,100]
    amount = 40
    print("Minimum number of coins needed:", solution.coinChange(coins, amount))  # Output: 3

if __name__ == "__main__":
    main()
