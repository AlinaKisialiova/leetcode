package medium;

/*
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Note:
You can assume that
0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer

Example 1:
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Example 2:
Input: amount = 3, coins = [2]
Output: 0
Example 3:
Input: amount = 10, coins = [10]
Output: 1
*/
public class CoinChange2 {

    public static void main(String[] args) {
        CoinChange2 exchanger = new CoinChange2();
        int result = exchanger.change(4, new int[]{1, 2, 5});
        assert result == 4 : "Solution is wrong";
        result = exchanger.change(3, new int[]{2});
        assert result == 0 : "Solution is wrong";
        result = exchanger.change(10, new int[]{10});
        assert result == 1 : "Solution is wrong";
    }

    public int change(int amount, int[] coins) {
        //index is intermediateAmount
        //value is numberOfCombinations
        int[] combinations = new int [amount + 1];
        combinations[0] = 1;
        for (int coin : coins) {
            for (int intermediateAmount = coin; intermediateAmount <= amount; intermediateAmount++) {
                combinations[intermediateAmount] += combinations[intermediateAmount - coin];
            }
        }
        return combinations[amount];
    }
}
