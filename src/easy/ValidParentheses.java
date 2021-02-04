package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validator = new ValidParentheses();
        boolean valid = validator.isValid("(){}[]");
        assert valid : "Solution is wrong";
        boolean invalid = !validator.isValid("([)]");
        assert invalid : "Solution is wrong";
    }

    public boolean isValid(String s) {
        int length = s.length();
        Map<Character, Character> openingByClosing = new HashMap<>();
        openingByClosing.put(')', '(');
        openingByClosing.put('}', '{');
        openingByClosing.put(']', '[');
        Stack stack = new Stack(length);
        for (char current : s.toCharArray()) {
            boolean isBracketClosing = openingByClosing.containsKey(current);
            if (isBracketClosing) {
                if (stack.size == 0 || openingByClosing.get(current) != stack.top()) {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(current);
            }
        }
        return stack.size == 0;
    }

    private static class Stack {
        char[] stack;
        int size = 0;

        public Stack(int capacity) {
            this.stack = new char[capacity];
        }

        public void push(char symbol) {
            if (size == stack.length) {
                throw new RuntimeException("Stack is full");
            }
            stack[size++] = symbol;
        }

        public char top() {
            if (size == 0) {
                throw new RuntimeException("Stack is empty");
            }
            return stack[size - 1];
        }

        public char pop() {
            if (size == 0) {
                throw new RuntimeException("Stack is empty");
            }
            return stack[--size];
        }
    }
}
