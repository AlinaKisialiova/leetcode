package easy;

/* #7
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverser = new ReverseInteger();
        int result = reverser.reverse(123);
        assert result == 321 : "Solution is wrong";
        result = reverser.reverse(-123);
        assert result == -321 : "Solution is wrong";
        result = reverser.reverse(120);
        assert result == 21 : "Solution is wrong";
        result = reverser.reverse(-1563847412);
        assert result == 0 : "Solution is wrong";
    }

    public int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) {
            return 0;
        }
        int reversed = 0;
        int remainderOfDivision;
        int divisible = Math.abs(x);
        while (divisible > 0) {
            // over(under)flow:
            // Integer.MAX_VALUE + 1 == Integer.MIN_VALUE
            // Integer.MIN_VALUE - 5 == Integer.MAX_VALUE - 4
            if (reversed < 0 || reversed * 10 / 10 != reversed) return 0;
            remainderOfDivision = divisible % 10;
            reversed = reversed * 10 + remainderOfDivision;
            divisible /= 10;
        }
        return reversed * Integer.signum(x);
    }
}