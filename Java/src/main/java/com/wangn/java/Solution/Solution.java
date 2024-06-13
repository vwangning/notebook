package com.wangn.java.Solution;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double medianSortedArrays = findMedianSortedArrays(nums1,nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 俩个数组合并然后排序
        int[] nums3 = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums3[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            nums3[nums1.length + i] = nums2[i];
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums3.length - i - 1; j++) {
                if (nums3[j] > nums3[j + 1]) {
                    int temp = nums3[j];
                    nums3[j] = nums3[j + 1];
                    nums3[j + 1] = temp;
                }
            }
        }
        if (nums3.length % 2 == 0) {
            return (nums3[nums3.length / 2] + nums3[nums3.length / 2 - 1]) / 2.0;
        }
        else{
            return nums3[nums3.length / 2];
        }

    }
}