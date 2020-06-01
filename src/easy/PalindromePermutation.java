package easy;

import java.util.HashMap;
import java.util.Map;

/* #266
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:
Input: "code"
Output: false

Example 2:
Input: "aab"
Output: true

Example 3:
Input: "carerac"
Output: true
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        PalindromePermutation permutator = new PalindromePermutation();
        boolean result = permutator.canPermutePalindrome("code");
        assert !result : "Solution is wrong";
        result = permutator.canPermutePalindrome("aab");
        assert result : "Solution is wrong";
        result = permutator.canPermutePalindrome("carerac");
        assert result : "Solution is wrong";
    }

    /*
     * If a string has an even length is a palindrome, when every character occurs an even number of times.
     * If the string has an odd length is a palindrome, when every character except one occurs an even number of times.
     * Time complexity: O(n);
     * Space complexity: O(n);
     */
    public boolean canPermutePalindrome(String s) {
        // int [128] array can be used to make space consumption O(128).
        // array index is ASCII code of a character
        Map<Character, Integer> numberOfOccursByChar = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            Integer numberOfOccurs = numberOfOccursByChar.getOrDefault(ch, 0);
            numberOfOccursByChar.put(ch, ++numberOfOccurs);
        }
        int count = 0;
        for (Character ch : numberOfOccursByChar.keySet()) {
            Integer numberOfOccurs = numberOfOccursByChar.get(ch);
            count += numberOfOccurs % 2;
        }
        return count <= 1;
    }
}
