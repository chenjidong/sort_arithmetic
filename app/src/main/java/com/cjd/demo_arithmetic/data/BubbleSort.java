package com.cjd.demo_arithmetic.data;

/**
 * 冒泡排序
 *
 * @Author chenjidong
 * @data
 * @Description 比较相邻的元素，如果第一个比第二个大 则交换
 **/
public class BubbleSort extends BaseSort {


    @Override
    public void sort(int[] arr) {
        int count = 0;

        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            count++;
            callback(arr, count);

            if (!flag) {
                break;
            }

        }
        finish(arr);
    }

    @Override
    public String desc() {
        return "比较相邻的元素，如果第一个比第二个大 则交换";
    }

    @Override
    public String title() {
        return "冒泡排序";
    }
}
