package com.cjd.demo_arithmetic.data;

import java.io.Serializable;

/**
 * @Author chenjidong
 * @data
 * Description:
 **/
public class BaseSort implements Serializable {
    private OnSortCallbackListener onSortCallbackListener;

    public OnSortCallbackListener getSortCallbackListener() {
        return onSortCallbackListener;
    }

    public void setSortCallbackListener(OnSortCallbackListener onSortCallbackListener) {
        this.onSortCallbackListener = onSortCallbackListener;
    }

    protected void print(int[] arr) {

        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public String toString(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        return builder.toString();
    }

    public interface OnSortCallbackListener {
        /**
         * @param arr   排序后返回的数组
         * @param count 当前次数
         */
        void onCallback(int[] arr, int count);

        void onFinish(int[] arr);
    }
}
