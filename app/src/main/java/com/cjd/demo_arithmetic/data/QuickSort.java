package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data 2019/9/17.
 * @Description:
 **/
public class QuickSort extends BaseSort {
    int count = 0;

    @Override
    public void sort(int[] arr) {
        count = 0;
        quick(arr, 0, arr.length - 1);
        finish(arr);
    }

    private void quick(int[] arr, int first, int last) {
        if (last > first) {
            print(arr);
            int pivotIndex = findPivot(arr, first, last);
            quick(arr, first, pivotIndex - 1);
            quick(arr, pivotIndex + 1, last);
        }
    }

    private int findPivot(int[] arr, int first, int last) {
        int pivot = arr[first];
        int low = first + 1;
        int high = last;
        while (low < high) {
            /**
             * 从前向后和从后向前依次和主元比较，当前面的元素比主元大，后面的元素比主元小则这两个元素互换位置
             */
            while (low <= high && arr[low] <= pivot) {
                low++;
            }
            while (low <= high && arr[high] >= pivot) {
                high--;
            }
            if (high > low) {
                int temp = arr[high];
                arr[high] = arr[low];
                arr[low] = temp;
            }
        }
        while (high > first && arr[high] >= pivot) {
            high--;
        }

        int result;
        if (pivot > arr[high]) {
            arr[first] = arr[high];
            arr[high] = pivot;
            result = high;
        } else
            result = first;

        count++;
        callback(arr, count);
        return result;
    }

    @Override
    public String desc() {
        return "通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。";
    }

    @Override
    public String title() {
        return "快速排序";
    }
}
