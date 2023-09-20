package com.wx.appbackend.study.sort;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/7/17
 */
public class SelectSort{
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 45, 65, 33, 12};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
