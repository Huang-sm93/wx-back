package com.wx.appbackend.study.forwork;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/12/27
 */
public class RemoveElement {
    public static void main(String[] args) {

    }

    static class Solution {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
            }
            return i;
        }
    }
}
