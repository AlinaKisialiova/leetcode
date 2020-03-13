package easy;

import java.util.Arrays;
import java.util.Comparator;

/* #1029
There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
and the cost of flying the i-th person to city B is costs[i][1].
Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Note:
1 <= costs.length <= 100
It is guaranteed that costs.length is even.
1 <= costs[i][0], costs[i][1] <= 1000

Example 1:
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation:
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*/
public class TwoCityScheduling {

    public static void main(String[] args) {
        TwoCityScheduling scheduler = new TwoCityScheduling();
        int result = scheduler.twoCitySchedCost(new int[][]{{259, 770}, {926, 667}, {577, 469}, {448, 54}, {184, 139}, {840, 118}});
        assert result == 1859 : "Solution is wrong";
        result = scheduler.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}});
        assert result == 110 : "Solution is wrong";
    }

    private static Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);

    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs.length > 100) {
            throw new IllegalArgumentException("'costs' must be 1 <= costs.length <= 100");
        }
        Arrays.sort(costs, comparator);
        final int length = costs.length;
        final int maxCount = length / 2;
        int sum = 0, countA = 0, countB = 0, i = 0;
        while (i < length) {
            final int costToA = costs[i][0];
            final int costToB = costs[i][1];
            if ((costToA <= costToB && countA < maxCount) || countB == maxCount) {
                sum += costToA;
                countA++;
            } else {
                sum += costToB;
                countB++;
            }
            i++;
        }
        return sum;
    }
}
