package medium;

import java.util.*;

/* # 127 Word Ladder
Given two words (beginWord and endWord), and a dictionary's word list,
find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:
Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Example 2:
Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
public class WordLadder {

    public static void main(String[] args) {
        WordLadder calculator = new WordLadder();
        int result = calculator.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        assert result == 5 : "Solution is wrong";
        result = calculator.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        assert result == 0 : "Solution is wrong";
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        final int wordLength = beginWord.length();
        HashMap<String, List<String>> wordsByMask = new HashMap<>();
        fill(wordList, wordsByMask);
        Queue<Map.Entry<String, Integer>> queue = new LinkedList<>();
        //hashmap is faster than list
        HashMap<String, Boolean> visited = new HashMap<>();

        queue.add(new AbstractMap.SimpleEntry<>(beginWord, 1));
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Map.Entry<String, Integer> wordAndLevel = queue.remove();
            String word = wordAndLevel.getKey();
            Integer level = wordAndLevel.getValue();

            for (int i = 0; i < wordLength; i++) {
                String mask = getMask(word, i);
                for (String adjacentWord : wordsByMask.getOrDefault(mask, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if(!visited.containsKey(adjacentWord)){
                        visited.put(adjacentWord, true);
                        queue.add(new AbstractMap.SimpleEntry<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    private void fill(List<String> wordList, HashMap<String, List<String>> wordsByMask) {
        final int wordLength = wordList.get(0).length();
        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                final String mask = getMask(word, i);
                List<String> words = wordsByMask.getOrDefault(mask, new ArrayList<>());
                words.add(word);
                wordsByMask.put(mask, words);
            }
        }
    }
    private String getMask(String word, int i) {
        return word.substring(0, i) + "_" + word.substring(i + 1);
    }
}
