public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        int copyOfX = x;
        int reversed = 0;
        while (copyOfX != 0) {
            reversed = reversed * 10 + copyOfX % 10;
            copyOfX /= 10;
        }
        return x == reversed;
    }

}
