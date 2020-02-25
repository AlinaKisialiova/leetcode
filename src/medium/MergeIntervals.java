package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* #56
Given a collection of intervals, merge all overlapping intervals.

Example 1:
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) {
        MergeIntervals merger = new MergeIntervals();
        int[][] result = merger.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        assert equal(result, new int[][]{{1, 6}, {8, 10}, {15, 18}}) : "Solution is wrong";
        result = merger.merge(new int[][]{{1, 4}, {4, 5}});
        assert equal(result, new int[][]{{1, 5}}) : "Solution is wrong";
    }

    private static boolean equal(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (!Arrays.equals(arr1[i], arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            System.out.println("Nothing to check. Input param is null");
            return new int[0][];
        }
        Arrays.sort(intervals, new IntervalComparator());

        List<int[]> output = new ArrayList<>();
        int length = intervals.length;
        int[] current = intervals[0];
        for (int i = 1; i < length; i++) {
            int[] next = intervals[i];
            if (current[1] >= next[0]) {
                current = combine(current, next);
            } else {
                output.add(current);
                current = next;
            }
        }
        output.add(current);
        return output.toArray(new int[output.size()][2]);
    }

    private static int[] combine(int[] current, int[] next) {
        return new int[]{Math.min(current[0], next[0]), Math.max(current[1], next[1])};
    }

    private static class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] < b[0]) {
                return -1;
            }
            return a[0] == b[0] ? 0 : 1;
        }
    }
}