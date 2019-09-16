package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data 2019/9/16.
 * @Description 选择排序，比较数组中最小的数值 小的放左边 依次类推
 **/
public class SelectionSort extends BaseSort {

    @Override
    public void sort(int[] arr) {
        if (arr.length == 0)
            return;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {//找到最小数
                    minIndex = j;//记录
                }
            }
            int temp = arr[minIndex];//交换
            arr[minIndex] = arr[i];
            arr[i] = temp;
            count++;
            callback(arr, count);
        }
        finish(arr);
    }

    @Override
    public String desc() {
        return "选择排序，比较数组中最小的数值 小的放左边 依次类推";
    }

    @Override
    public String title() {
        return "选择排序";
    }
}
