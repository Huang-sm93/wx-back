package com.wx.appbackend.forwork;

/**
 * 最长回文子串
 * User:  sm.huang
 * Date:  2023/12/25
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("iptmykvjanwiihepqhzupneckpzomgvzmyoybzfynybpfybngttozprjbupciuinpzryritfmyxyppxigitnemanreexcpwscvcwddnfjswgprabdggbgcillisyoskdodzlpbltefiz"));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.length() == 0){
                return "";
            }
            int start = 0;
            int countMax = 0;
            String arr[] = s.split("");
            for (int i = 1; i < arr.length - 1; i++) { // 以i为中心
                int count = 0;
                for (int j = 1; j <= i; j++) {
                    if ((i+j<arr.length)&&arr[i-j].equals(arr[i+j])){
                        count += 1;
                    }else {
                        break;
                    }
                }
                if (count > countMax){
                    start = i;
                    countMax = count;
                }
            }

            int start1 = 0;
            int countMax1 = 0;
            for (int i = 1; i < arr.length; i++) { // 以i和i+1为中心
                int count = 0;
                for (int j = 0; j < i; j++) {
                    if ((i+j< arr.length) && arr[i-1-j].equals(arr[i+j])){
                        count += 1;
                    }else {
                        break;
                    }
                }
                if (count > countMax1){
                    start1 = i;
                    countMax1 = count;
                }
            }
            int startIndex = 0;
            int endIndex = 0;
            if (countMax1*2 > countMax*2+1){
                startIndex = start1-countMax1;
                endIndex = start1+countMax1;
            }else {
                startIndex = start-countMax;
                endIndex = start+countMax+1;
            }
            return s.substring(startIndex, endIndex);
        }
    }

}
