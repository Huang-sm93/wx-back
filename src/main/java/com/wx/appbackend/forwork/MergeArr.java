package com.wx.appbackend.forwork;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/12/26
 */
public class MergeArr {
    public static void main(String[] args) {

    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) {
                return;
            }
            if (m == 0) {
                for (int i = 0; i < n; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            int index1 = m - 1;
            int index2 = n - 1;
            for (int i = 0; i < m+n; i++) {
                if (index1 < 0) {
                    nums1[m + n - 1 - i] = nums2[index2];
                    index2--;
                    continue;
                }
                if (index2 < 0) {
                    nums1[m + n - 1 - i] = nums1[index1];
                    index1--;
                    continue;
                }
                if (nums1[index1] < nums2[index2]) {
                    nums1[m + n - 1 - i] = nums2[index2];
                    index2--;
                } else {
                    nums1[m + n - 1 - i] = nums1[index1];
                    index1--;
                }
            }
        }
    }
}
