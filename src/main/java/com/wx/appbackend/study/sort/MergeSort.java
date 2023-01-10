package com.wx.appbackend.study.sort;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/1/10
 * Desc: 归并排序(Merge Sort)
 */
public class MergeSort {

    public static void sort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    //递归实现
    public static void mergeSort(int[] arr, int left, int right){
        if (left == right){
            return;
        }
        int mid = (left+right)/2;
        //左边拆分
        mergeSort(arr, left, mid);
        //右边拆分
        mergeSort(arr, mid+1, right);
        //拆分完成开始合并
        int leftStart = left;
        int leftEnd = mid;
        int rightStart = mid+1;
        int rightEnd = right;
        for (int i = left; i < right; i++) {

        }
    }
}
