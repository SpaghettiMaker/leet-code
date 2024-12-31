# Palindrome Number

## Intuition
A number is considered a palindrome if it reads the same forwards and backwards. For example, `121` is a palindrome because reversing it gives the same value `121`. However, `123` is not a palindrome because reversing it gives `321`.

To check if a number is a palindrome, we can reverse the number and compare it to the original. If the reversed number equals the original, then the number is a palindrome. This definition aligns with the idea of a palindrome in general, whether it is a word, number, or sequence.

The approach used here is similar to the solution for the problem **7 - Reverse Integer**, where we reverse the number using arithmetic operations.

## Approach
1. **Special Cases**:
   - Negative numbers are not palindromes because the negative sign is not symmetric.
   - Single-digit numbers are always palindromes because they read the same forwards and backwards.

2. **Reversing the Number**:
   - Start with a copy of the number (`copyOfX`).
   - Extract the last digit using the modulo operator: `copyOfX % 10`.
   - Build the reversed number by multiplying the current reversed value by \(10\) and adding the extracted digit.
   - Remove the last digit from the copy using integer division: `copyOfX /= 10`.

3. **Comparison**:
   - Once the number is reversed, compare it to the original number. If they are equal, the number is a palindrome.

4. **Efficiency**:
   - This approach avoids converting the number into a string, making it more efficient in terms of memory usage.

## Complexity
- **Time Complexity**:  
  \(O(d)\), where \(d\) is the number of digits in the input number. Each digit is processed once during the reversal.

- **Space Complexity**:  
  \(O(1)\), as no additional memory is used apart from a few variables for computation.

## Code
```java []
public class Solution {

    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0)
            return false;

        // Single-digit numbers are palindromes
        if (x < 10)
            return true;

        int copyOfX = x;
        int reversed = 0;

        // Reverse the number
        while (copyOfX != 0) {
            reversed = reversed * 10 + copyOfX % 10;
            copyOfX /= 10;
        }

        // Compare the original and reversed numbers
        return x == reversed;
    }

}
