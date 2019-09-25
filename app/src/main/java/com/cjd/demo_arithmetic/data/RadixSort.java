package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data 2019/9/18.
 * @Description:
 **/
public class RadixSort extends BaseSort {
    @Override
    public void sort(int[] arr) {

        radixSort(arr, getMaxDigit(arr));
    }

    private int getMaxDigit(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max)
                max = num;
        }
        int count = 0;
        while (max >= 1) {
            max /= 10;
            count++;
        }
        return (int) Math.pow(10, count);
    }

    /**
     * @param arr
     * @param d   最大位数  获取arr 中最高位
     */
    private void radixSort(int[] arr, int d) {
        int n = 1;//代表位数对应的数 1，10，100，1000 ...
        int k = 0;//保存每一位排序后的结果用于下一位的排序输入
        int length = arr.length;
        //排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[][] bucket = new int[10][length];
        ////用于保存每个桶里有多少个数字
        int[] order = new int[length];

        while (n < d) {
            for (int num : arr) {//将数组array里的每个数字放在相应的桶里
                int digit = (num / n) % 10;//计算当前值的位数
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }

            for (int i = 0; i < length; i++) {
                if (order[i] != 0) {//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                    for (int j = 0; j < order[i]; j++) {
                        arr[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;//将桶里计数器置0，用于下一次位排序
            }
            n *= 10;//进位
            k = 0;//将k置0，用于下一轮保存位排序结果
        }
    }

    @Override
    public String desc() {
        return null;
    }

    @Override
    public String title() {
        return "基数排序";
    }
}
