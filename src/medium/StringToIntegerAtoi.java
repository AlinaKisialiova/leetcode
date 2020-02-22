package medium;

/* #8
Implement atoi which converts a string to an integer.
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned.

Note:
Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

Example 2:
Input: "   -42"
Output: -42
Example 3:
Input: "4193 with words"
Output: 4193
Example 5:
Input: "-91283472332"
Output: -2147483648
*/
public class StringToIntegerAtoi {

    public static void main(String[] args) {
        int digit = myAtoi("   -42");
        assert digit == -42 : "Solution is wrong";
        digit = myAtoi("4193 with words");
        assert digit == 4193 : "Solution is wrong";
        digit = myAtoi("-91283472332");
        assert digit == -2147483648 : "Solution is wrong";
    }

    public static int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        String trimmed = str.trim();
        boolean signed = isSign(trimmed.charAt(0));
        boolean negative = signed && trimmed.contains("-");
        int limit = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int result = 0;
        int i = signed ? 1 : 0;
        int length = trimmed.length();
        while (i < length) {
            char ch = trimmed.charAt(i);
            if (!isDigit(ch)) {
                break;
            }
            if (isOutOfLimit(result, limit, Character.digit((int) ch, 10))) {
                result = limit;
                break;
            }
            result *= 10;
            result += Character.digit(ch, 10);
            i++;
        }
        return negative ? -result : result;

    }

    private static boolean isOutOfLimit(int number, int limit, int current) {
        int minusOneClassFromLimit = Math.abs(limit / 10);
        return minusOneClassFromLimit < number ||
                (minusOneClassFromLimit == number && Math.abs(limit % 10) < current);
    }

    private static boolean isDigit(int charCode) {
        return charCode >= 48 && charCode <= 57;
    }

    private static boolean isSign(int charCode) {
        return charCode == 43 || charCode == 45;
    }
}
