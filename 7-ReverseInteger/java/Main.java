public class Main {
    public static void main(String[] args) {
        System.out.println(reverse(2333330));
    }

    public static int reverse(int x) {
        int reversed = 0;
        int MAX_VALUE = Integer.MAX_VALUE;
        int MIN_VALUE = Integer.MIN_VALUE;
        while (x != 0) {
            int digit = x % 10; // Extract the last digit

            if (reversed > MAX_VALUE / 10 || (reversed == MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (reversed < MIN_VALUE / 10 || (reversed == MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed;
    }
}
