public class Solution {

    public int myAtoi(String s) {
        long result = 0;
        boolean isNegative = false;
        boolean hasSign = false;
        boolean isParsing = false;

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (isParsing)
                    break;
                continue;
            }

            if (c == '+' || c == '-') {
                if (isParsing || hasSign)
                    break;
                isNegative = (c == '-');
                hasSign = true;
                isParsing = true;
                continue;
            }

            if (c >= '0' && c <= '9') {
                isParsing = true;
                int digit = c - '0';
                result = result * 10 + digit;

                if (result > Integer.MAX_VALUE)
                    break;

                continue;
            }
            break;
        }

        if (isNegative)
            result = -result;
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }
}
