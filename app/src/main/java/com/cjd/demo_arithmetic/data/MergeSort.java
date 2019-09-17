package com.cjd.demo_arithmetic.data;

import java.util.Arrays;

/**
 * @Author chenjidong
 * @data 2019/9/17.
 * @Description:
 **/
public class MergeSort extends BaseSort {
    int count = 0;

    @Override
    public void sort(int[] arr) {
        count = 0;
        arr = mergeSort(arr);
        finish(arr);
    }

    private int[] mergeSort(int[] arr) {
        if (arr.length < 2)
            return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        print(left);
        print(right);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else
                result[index] = left[i++];
        }
        count++;
        callback(result, count);
        return result;
    }

    @Override
    public String desc() {
        return "将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并";
    }

    @Override
    public String title() {
        return "归并排序";
    }
}
