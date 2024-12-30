# Intuition
When solving the problem of finding the median of two sorted arrays, the key insight is that merging the arrays partially up to the required median values is sufficient. There's no need to fully merge the arrays.

# Approach
1. Handle edge cases:
   - If one array is empty, directly calculate the median of the non-empty array.
   - If the combined length of both arrays is exactly 2, directly compute the median of the two elements.

2. Calculate the number of elements needed to determine the median:
   - For odd-length combined arrays, we need just over half the elements.
   - For even-length combined arrays, we need one additional element to calculate the average of the two middle values.

3. Merge the arrays incrementally up to the calculated number of elements:
   - Use two pointers to traverse the arrays, and compare elements from both arrays.
   - Append the smaller element to a temporary merged array.

4. Calculate the median based on the final merged array:
   - If the total length is odd, the last element of the merged array is the median.
   - If the total length is even, the median is the average of the last two elements in the merged array.

# Complexity
- **Time complexity:**
  $$O(m + n)$$ where $m$ and $n$ are the lengths of the two arrays. Since we only merge up to the required number of elements, the actual iteration cost is proportional to the smaller of $m$ and $n$.

- **Space complexity:**
  $$O(k)$$ where $k$ is the number of elements needed for median calculation. In the worst case, $k \approx \lceil (m + n) / 2 \rceil$.

# Code
```java []
class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return calculateMedian(nums2);
        }
        if (nums2.length == 0) {
            return calculateMedian(nums1);
        }

        int totalLength = nums1.length + nums2.length;
        if (totalLength == 2) {
            return calculateMedianOfTwoElements(nums1, nums2);
        }

        int medianElementsCount = calculateMedianElementsCount(totalLength);
        int[] mergedArray = mergeUntilCount(nums1, nums2, medianElementsCount);

        return calculateFinalMedian(mergedArray, totalLength);
    }

    private int calculateMedianElementsCount(int totalLength) {
        int medianElements = (totalLength + 1) / 2;
        return (totalLength % 2 == 0) ? medianElements + 1 : medianElements;
    }

    private int[] mergeUntilCount(int[] nums1, int[] nums2, int count) {
        int[] merged = new int[count];
        int i = 0, j = 0, z = 0;

        while (z < count) {
            if (getArrayValue(nums1, i) <= getArrayValue(nums2, j)) {
                merged[z++] = nums1[i++];
            } else {
                merged[z++] = nums2[j++];
            }
        }

        return merged;
    }

    private int getArrayValue(int[] array, int index) {
        return (index < array.length) ? array[index] : Integer.MAX_VALUE;
    }

    private double calculateFinalMedian(int[] mergedArray, int totalLength) {
        if (totalLength % 2 == 1) {
            return mergedArray[mergedArray.length - 1];
        }
        return (mergedArray[mergedArray.length - 1] + mergedArray[mergedArray.length - 2]) / 2.0;
    }

    public double calculateMedian(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return nums[n / 2];
        }
        return (nums[(n / 2) - 1] + nums[n / 2]) / 2.0;
    }

    public double calculateMedianOfTwoElements(int[] nums1, int[] nums2) {
        return (nums1[0] + nums2[0]) / 2.0;
    }
}
```

