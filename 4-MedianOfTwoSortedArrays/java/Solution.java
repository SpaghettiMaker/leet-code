package java;

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
