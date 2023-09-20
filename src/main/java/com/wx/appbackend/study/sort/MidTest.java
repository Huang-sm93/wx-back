package com.wx.appbackend.study.sort;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/7/17
 */
public class MidTest {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    public static int guessNumber(int n) {
        int left = 0;
        int right = n;
        while(left <= right){
            int mid = (right-left)/2 + left;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) > 0){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }

    public static int guess(int num){
        return 6-num;
    }
}
