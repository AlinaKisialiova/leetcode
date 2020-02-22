package easy;

/* #1047
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

Input: "abbaca"
Output: "ca"

Note:
1 <= S.length <= 20000
S consists only of English lowercase letters.

*/
public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        String result = new RemoveAdjacentDuplicates().removeDuplicates("abbaca");
        assert "ca".equals(result) : "Wrong result";
    }

    String removeDuplicates(String s) {
        if (s == null || s.isEmpty() || s.length() > 20000) {
            throw new IllegalArgumentException("Input string must be 1 <= s.length <= 20000");
        }
        int length = s.length();
        Stack temp = new Stack(length);
        temp.push(s.charAt(0));
        for (int i = 1; i < length; i++) {
            char currentLetter = s.charAt(i);
            if (temp.top() == currentLetter) {
                temp.pop();
            } else {
                temp.push(currentLetter);
            }
        }

        StringBuilder result = new StringBuilder();
        while (temp.isNotEmpty()) {
            result.insert(0, temp.pop());
        }
        return result.toString();
    }

    class Stack {
        char[] stack;
        int size = 0;

        Stack(int capacity) {
            this.stack = new char[capacity];
        }

        void push(char s) {
            stack[size++] = s;
        }

        char pop() {
            if (size == 0) {
                return '\0';
            }
            return stack[--size];
        }

        char top() {
            if (size == 0) {
                return '\0';
            }
            return stack[size - 1];
        }

        boolean isNotEmpty() {
            return size > 0;
        }
    }
}