package medium;

/* #1143
Given two strings text1 and text2, return the length of their longest common subsequence.
A subsequence of a string is a new string generated from the original string with some characters(can be none)
deleted without changing the relative order of the remaining characters.
(eg, "ace" is a subsequence of "abcde" while "aec" is not).
A common subsequence of two strings is a subsequence that is common to both strings.
If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace"
Output: 3
Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0

Constraints:
1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
*/
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence searcher = new LongestCommonSubsequence();
        int result = searcher.longestCommonSubsequence("abcde", "ace");
        assert result == 3 : "Solution is wrong";
        result = searcher.longestCommonSubsequence("abc", "abc");
        assert result == 3 : "Solution is wrong";
        result = searcher.longestCommonSubsequence("abc", "def");
        assert result == 0 : "Solution is wrong";
    }

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0 ||
                text1.length() > 1000 || text2.length() > 1000) {
            return 0;
        }
        int text1Length = text1.length();
        int text2Length = text2.length();
        int[][] matrix = new int[text1Length + 1][text2Length + 1];
        for (int i = 1; i <= text1Length; i++) {
            for (int j = 1; j <= text2Length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                }
            }
        }
        return matrix[text1Length][text2Length];
    }
}
