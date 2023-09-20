package com.wx.appbackend.study.day810;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/8/10
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeros(int[] nums){
        int index = 0;
        for (int num : nums) {
            if(num != 0){
                nums[index++] = num;
            }
        }
        while(index < nums.length){
            nums[index++] = 0;
        }
    }
}
