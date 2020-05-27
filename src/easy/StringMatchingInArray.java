package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* #1408
Given an array of string words. Return all strings in words which is substring of another word in any order.
String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

Example 1:
Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.

Example 2:
Input: words = ["leetcode","et","code"]
Output: ["et","code"]
Explanation: "et", "code" are substring of "leetcode".

Example 3:
Input: words = ["blue","green","bu"]
Output: []
 */
public class StringMatchingInArray {

    public static void main(String[] args) {
        StringMatchingInArray finder = new StringMatchingInArray();
        List<String> result = finder.stringMatching(new String[]{"mass", "as", "hero", "superhero"});
        assert "as".equals(result.get(0)) && "hero".equals(result.get(1)) : "Solution is wrong";
        result = finder.stringMatching(new String[]{"leetcode", "et", "code"});
        assert "code".equals(result.get(0)) && "et".equals(result.get(1))  : "Solution is wrong";
        result = finder.stringMatching(new String[]{"blue", "green", "bu"});
        assert result.isEmpty() : "Solution is wrong";
    }

    public List<String> stringMatching(String[] words) {
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    result.add(words[j]);
                }
            }
        }
        return new ArrayList<>(result);
    }
}
