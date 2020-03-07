package medium;

/* #322
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
Note:
You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange exchanger = new CoinChange();
        int result = exchanger.coinChange(new int[]{1, 2, 5}, 11);
        assert result == 3 : "Solution is wrong";
        result = exchanger.coinChange(new int[]{2}, 3);
        assert result == -1 : "Solution is wrong";
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return -1;
        }
        // index is certain amount
        // value is min count of coins required to make amount
        int[] minNumbersOfCoins = new int[amount + 1];
        // 0 coins need to make 0 amount
        minNumbersOfCoins[0] = 0;
        for (int intermediateAmount = 1; intermediateAmount <= amount; intermediateAmount++) {
            // overwrite default int value(0) by max high to chose min value correctly on the next step
            minNumbersOfCoins[intermediateAmount] = amount + 1;
            for (int coin : coins) {
                if (coin <= intermediateAmount) {
                    minNumbersOfCoins[intermediateAmount] = Math.min(minNumbersOfCoins[intermediateAmount], minNumbersOfCoins[intermediateAmount - coin] + 1);
                }
            }
        }
        return minNumbersOfCoins[amount] > amount ? -1 : minNumbersOfCoins[amount];
    }
}
