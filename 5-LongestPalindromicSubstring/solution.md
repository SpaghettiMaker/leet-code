# Longest Palindromic Substring

## Intuition
To find the longest palindromic substring, we leverage the fact that a palindrome is symmetrical around its center. This symmetry allows us to efficiently expand outward from potential centers to check for palindromes. Instead of checking all substrings explicitly, we focus on valid palindromic substrings by expanding around these centers.

## Approach
1. **Center Expansion**:  
   - Each character in the string can act as the center of a palindrome.
   - For even-length palindromes, pairs of adjacent characters can also act as a center.
   - Expand outward from the center while the characters on the left and right are equal.

2. **Tracking the Longest Palindrome**:  
   - For each center, calculate the length of the palindrome by expansion.
   - Update the start and end indices of the longest palindrome whenever a longer one is found.

3. **Helper Function**:  
   - A helper function, `findLongestPalindrome`, performs the expansion from a given center and calculates the palindrome's length.

## Complexity
- **Time Complexity**:  
  \(O(n^2)\), where \(n\) is the length of the string. For each of the \(2n - 1\) centers (one for each character and one for each pair of adjacent characters), the expansion takes \(O(n)\) in the worst case.

- **Space Complexity**:  
  \(O(1)\), as no additional space proportional to the input size is used. Only a few variables are maintained for tracking indices and lengths.

## Code
```java
class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Palindrome with single character center
            int len1 = findLongestPalindrome(s, i, i);

            // Palindrome with two-character center
            int len2 = findLongestPalindrome(s, i, i + 1);

            // Determine the longer palindrome
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;  // Update start index
                end = i + len / 2;         // Update end index
            }
        }

        return s.substring(start, end + 1);
    }

    private int findLongestPalindrome(String s, int left, int right) {
        // Expand outward as long as the substring is a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length of the palindrome is right - left - 1
        return right - left - 1;
    }
}
