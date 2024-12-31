class Solution {
    private int MAX_VALUE = Integer.MAX_VALUE;
    private int MIN_VALUE = Integer.MIN_VALUE;

    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int lastDigit = x % 10;

            if (validateOverflow(reversed, lastDigit)) {
                return 0;
            }

            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }
        return reversed;
    }

    private boolean validateOverflow(int reversed, int lastDigit) {
        if (reversed > MAX_VALUE / 10 || (reversed == MAX_VALUE / 10 && lastDigit > 7)) {
            return true;
        }

        if (reversed < MIN_VALUE / 10 || (reversed == MIN_VALUE / 10 && lastDigit < -8)) {
            return true;
        }
        return false;
    }
}
