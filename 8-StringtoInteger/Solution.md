## Intuition
The main insight for solving this problem is that every character in a string has an associated integer value based on the **ASCII table**. For example:
- `'0'` has an ASCII value of `48`.
- `'1'` has an ASCII value of `49`.
- `'2'` has an ASCII value of `50`.
- ...
- `'9'` has an ASCII value of `57`.

By leveraging this, we can convert a character representing a digit into its corresponding integer value by subtracting the ASCII value of `'0'` (which is `48`). This operation works because the digits `'0'` to `'9'` are stored sequentially in the ASCII table.

For example:
- `'3' - '0'` becomes `51 - 48 = 3`.
- `'7' - '0'` becomes `55 - 48 = 7`.

This approach avoids the need for complex parsing logic and directly extracts the numeric value of the character.

## Approach
1. **Initialization**:
   - Use a `long` variable (`result`) to store the converted number and detect overflow.
   - Use flags (`isNegative`, `hasSign`, `isParsing`) to handle signs, whitespace, and parsing state.

2. **Iterate Through Characters**:
   - **Leading Whitespace**: Skip spaces until parsing starts.
   - **Sign Detection**: If a `+` or `-` is encountered, set the `isNegative` flag appropriately.
   - **Digit Conversion**:
     - Check if the character is between `'0'` and `'9'`.
     - Convert the character to an integer by subtracting `'0'`.
     - Accumulate the result: `result = result * 10 + (c - '0')`.
   - **Invalid Characters**: Stop parsing when encountering any non-digit character after parsing starts.

3. **Post-Processing**:
   - Apply the negative sign if `isNegative` is `true`.
   - Clamp the result to the 32-bit signed integer range if necessary.

4. **Return the Result**:
   - Cast the result to `int`.

## ASCII Values of Digits
| Character | ASCII Value | Conversion Example (`c - '0'`) |
|-----------|-------------|-------------------------------|
| `'0'`     | 48          | `48 - 48 = 0`                |
| `'1'`     | 49          | `49 - 48 = 1`                |
| `'2'`     | 50          | `50 - 48 = 2`                |
| `'3'`     | 51          | `51 - 48 = 3`                |
| `'4'`     | 52          | `52 - 48 = 4`                |
| `'5'`     | 53          | `53 - 48 = 5`                |
| `'6'`     | 54          | `54 - 48 = 6`                |
| `'7'`     | 55          | `55 - 48 = 7`                |
| `'8'`     | 56          | `56 - 48 = 8`                |
| `'9'`     | 57          | `57 - 48 = 9`                |

This straightforward arithmetic makes the conversion process efficient and easy to understand.

## Complexity
- **Time Complexity**:  
  \(O(n)\), where \(n\) is the length of the string. Each character is processed once.

- **Space Complexity**:  
  \(O(1)\), as no additional memory is allocated that depends on the input size.

## Code
```java []
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
                int digit = c - '0'; // ASCII-based conversion
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
