package medium;

import java.util.HashMap;
import java.util.Map;

/*
Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */
class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean found = trie.search("apple");
        assert found : "Solution is wrong";
        found = trie.search("app");
        assert !found : "Solution is wrong";
        found = trie.startsWith("app");
        assert found : "Solution is wrong";
        trie.insert("app");
        found = trie.search("app");
        assert found : "Solution is wrong";
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode current = root;
        for (Character l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, ch -> new TrieNode());
        }
        current.setEndOfWord();
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TrieNode lastMatchedCharacter = searchPrefix(word);
        return lastMatchedCharacter != null && lastMatchedCharacter.isEndOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        return searchPrefix(prefix) != null;
    }

    TrieNode searchPrefix(String prefix) {
        TrieNode current = root;
        for (Character l : prefix.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    class TrieNode {

        //for optimisation we can use just 'TrieNode[] children', where array index is ASCII code of letter number in latin alphabet stored in array(starts from 0).
        //Then to access to elements a char has to be converted to index for it in array: "ch -'a'";
        //For example: ch=m=109(ASCII code), 'a'=97; 109-97=12. M is 13th letter in general alphabet, but in array notation is 12.
        //http://www.asciitable.com/
        private Map<Character, TrieNode> children = new HashMap<>();

        private Boolean isEndOfWord = false;

        public Map<Character, TrieNode> getChildren() {
            return children;
        }

        public void setEndOfWord() {
            isEndOfWord = true;
        }
    }
}
