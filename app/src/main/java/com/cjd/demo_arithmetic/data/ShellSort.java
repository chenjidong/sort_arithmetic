package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data 2019/9/16.
 * @Description 希尔排序
 **/
public class ShellSort extends BaseSort {
    @Override
    public void sort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        int count = 0;
        while (gap > 0) {
            for (int i = 0; i < len; i++) {
                temp = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && temp < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }

                arr[preIndex + gap] = temp;
                count++;
                callback(arr, count);
            }
            gap /= 2;

        }
        finish(arr);
    }

    @Override
    public String desc() {
        return "先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序";
    }

    @Override
    public String title() {
        return "希尔排序";
    }
}
