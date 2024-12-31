public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        int copyOfX = x;
        int reversed = 0;
        while (copyOfX != 0) {
            int digit = copyOfX % 10;
            reversed = reversed * 10 + digit;
            copyOfX /= 10;
        }
        return x == reversed;
    }

}
