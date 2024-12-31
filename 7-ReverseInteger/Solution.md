# Arithmetic Solution: Reverse Integer in Just 1ms 🚀

## Intuition
The problem requires reversing the digits of an integer while keeping the result within the range of a 32-bit signed integer \([-2,147,483,648, 2,147,483,647]\). By leveraging arithmetic operations efficiently, we can achieve this in a fast and memory-efficient manner. The challenge lies in detecting and preventing overflow, which is inherent to fixed-size integer representations in Java.

## Approach
1. **Extracting the Last Digit**:  
   - Use the modulo operator `x % 10` to extract the last digit of the integer. For example, if \(x = 123\), `x % 10 = 3`. This digit will be used to build the reversed number.
   - Remove the last digit from \(x\) by performing integer division: `x / 10`. For example, \(123 / 10 = 12\).

2. **Reconstructing the Reversed Number**:  
   - Start with `reversed = 0`.
   - For each digit extracted, update the reversed number using the formula:  
     \[
     \text{reversed} = \text{reversed} \times 10 + \text{lastDigit}
     \]  
     This shifts the digits of `reversed` one place to the left and appends the extracted digit.

3. **Preventing Overflow**:  
   - Since Java integers have a fixed range, any operation exceeding \([-2,147,483,648, 2,147,483,647]\) causes an **overflow**. To avoid this:
     - **Positive Overflow**: Check if `reversed > Integer.MAX_VALUE / 10`, or if `reversed == Integer.MAX_VALUE / 10` and the next digit exceeds \(7\) (the last digit of \(2,147,483,647\)).
     - **Negative Overflow**: Check if `reversed < Integer.MIN_VALUE / 10`, or if `reversed == Integer.MIN_VALUE / 10` and the next digit is less than \(-8\) (the last digit of \(-2,147,483,648\)).
   - If an overflow is detected, return `0` immediately.

4. **Iterative Process**:
   - Repeat the steps of extracting digits, checking for overflow, and building the reversed number until all digits are processed (`x == 0`).

## Complexity
- **Time Complexity**:  
  \(O(d)\), where \(d\) is the number of digits in \(x\). Each digit is processed exactly once.

- **Space Complexity**:  
  \(O(1)\), since no additional memory is allocated.

## Code
```java []
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
