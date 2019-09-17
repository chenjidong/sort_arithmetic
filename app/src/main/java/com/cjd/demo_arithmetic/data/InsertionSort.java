package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data 2019/9/16.
 * @Description 插入排序
 **/
public class InsertionSort extends BaseSort {
    @Override
    public void sort(int[] arr) {
        int current;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {// 3 11 2 6 5
            current = arr[i + 1];//11
            int preIndex = i;//0
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
            count++;
            callback(arr, count);
        }

        finish(arr);
    }

    @Override
    public String desc() {
        return "从第一个元素开始，如果该元素大于新元素（i+1），将该元素移动到下一个位置";
    }

    @Override
    public String title() {
        return "插入排序";
    }
}
