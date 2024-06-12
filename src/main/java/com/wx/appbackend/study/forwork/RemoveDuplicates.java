package com.wx.appbackend.study.forwork;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/12/27
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = new int[]{3,0,6,1,5};
        Solution solution = new Solution();
        System.out.println(solution.hIndex(nums));
    }

    static class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0;
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (count == 1){
                    if (nums[i] != nums[slow]) {
                        slow++;
                        nums[slow] = nums[i];
                        count = 0;
                    }
                } else {
                    if (nums[i] != nums[slow]) {
                        slow++;
                        nums[slow] = nums[i];
                    } else {
                        count++;
                        slow++;
                        nums[slow] = nums[i];
                    }
                }

            }
            return slow+1;
        }

        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    Integer count = map.get(nums[i]);
                    map.put(nums[i], count + 1);
                } else {
                    map.put(nums[i], 1);
                }
                if (map.get(nums[i]) > nums.length/2) {
                    return nums[i];
                }
            }
            return 0;
        }

        // 旋转数组
        public void rotate(int[] nums, int k) {
            int rotateK = k % nums.length;
            int[] temp = nums.clone();
            for (int i = 0; i < nums.length-rotateK; i++) {
                nums[i] = nums[rotateK+i];
            }
            for (int i = 0; i < rotateK; i++) {
                nums[nums.length-rotateK+i] = temp[i];
            }
        }

        // 买卖股票的最佳时机
        public int maxProfit(int[] prices) {
            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if(prices[i] < minPrice){
                    minPrice = prices[i];
                } else if(prices[i] - minPrice > maxProfit){
                    maxProfit = prices[i] - minPrice;
                }
            }
            return maxProfit;
        }

        // 买卖股票的最佳时机1
        public int maxProfit1(int[] prices) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    maxProfit += prices[i] - prices[i-1];
                }
            }
            return maxProfit;
        }

        // H指数
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] count = new int[n+1];
            for (int i = 0; i < citations.length; i++) {
                count[Math.min(citations[i],n)] += 1;
            }
            int countV = 0;
            for (int i = count.length-1; i >= 0; i--) {
                if (count[i] + countV >= i) {
                    return i;
                }
                countV += count[i];
            }
            return 0;
        }
    }

    static class RandomizedSet {
        Map<Integer, Integer> map;

        public RandomizedSet() {
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            map.put(val, 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int index = (int) (Math.random() * map.size());
            return (int) map.keySet().toArray()[index];
        }
    }

    // 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        //从左往右乘
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i-1]*res[i-1];
        }
        int tempR = 1;
        //从右往左乘
        for (int i = nums.length-2; i >= 0; i--) {
            tempR = tempR*nums[i+1];
            res[i] = res[i]*tempR;
        }
        return res;
    }

}
