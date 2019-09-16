package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data
 * Description:
 **/
public class BubbleSort extends BaseSort {

    /**
     * 冒泡排序
     *
     * @param arr        排序数组
     * @param isOptimize 是否启用优化
     */
    public void bubbleSort(int[] arr, boolean isOptimize) {
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
            if (getSortCallbackListener() != null) {
                getSortCallbackListener().onCallback(arr, count);
            }
            if (isOptimize) {
                if (!flag) {
                    break;
                }
            }
        }
        if (getSortCallbackListener() != null)
            getSortCallbackListener().onFinish(arr);
    }
}
