package com.cjd.demo_arithmetic.data;

import java.io.Serializable;

/**
 * @Author chenjidong
 * @data Description:
 **/
public abstract class BaseSort implements Serializable {
    private OnSortCallbackListener onSortCallbackListener;

    public OnSortCallbackListener getSortCallbackListener() {
        return onSortCallbackListener;
    }

    public void setSortCallbackListener(OnSortCallbackListener onSortCallbackListener) {
        this.onSortCallbackListener = onSortCallbackListener;
    }

    public abstract void sort(int[] arr);

    public abstract String desc();

    public abstract String title();

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

    protected void callback(int[] arr, int count) {
        if (onSortCallbackListener != null)
            onSortCallbackListener.onCallback(arr, count);
    }

    protected void finish(int[] arr) {
        if (onSortCallbackListener != null)
            onSortCallbackListener.onFinish(arr);
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
