package com.wx.appbackend.study.sort;

import java.util.Arrays;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/1/10
 * Desc: 归并排序(Merge Sort)
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 45, 65, 33, 12};
        mergeSort(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    //递归实现
    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (right-left)/2 + left;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int leftIndex = left;
        int rightIndex = mid+1;
        int[] temp = new int[right-left+1];
        int tempIndex = 0;
        while (leftIndex <= mid && rightIndex <=right){
             if (arr[leftIndex] <= arr[rightIndex]){
                 temp[tempIndex++] = arr[leftIndex];
                 leftIndex++;
             }else{
                 temp[tempIndex++] = arr[rightIndex];
                 rightIndex++;
             }
        }

        while (leftIndex <= mid){
            temp[tempIndex++] = arr[leftIndex];
            leftIndex++;
        }

        while (rightIndex <= right){
            temp[tempIndex++] = arr[rightIndex];
            rightIndex++;
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i+left] = temp[i];
        }
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        for(int i=0; i<spells.length; i++){
            int expectValue = (int)(success/spells[i]);
            int left = 0;
            int right = potions.length-1;
            while(left < right){
                int mid = (right-left)/2 + left;
                if(potions[mid] < expectValue){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
        }
        return res;
    }
}
