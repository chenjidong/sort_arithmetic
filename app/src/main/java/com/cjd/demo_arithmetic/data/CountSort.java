package com.cjd.demo_arithmetic.data;

/**
 * @Author chenjidong
 * @data 2019/9/17.
 * @Description
 * @link https://www.jianshu.com/p/a2f47d9037f4
 **/
public class CountSort extends BaseSort {
    int count = 0;

    @Override
    public void sort(int[] arr) {
        count = 0;
        int max = getMax(arr);//获取最大值
        /**
         * 为什么要创建k+1的长度？因为array中最大值为k，那么array的值一定是0-k之间，
         * 而且countArray的下标代表array中的数，0-k之间有k+1个数。
         */
        int[] countArray = new int[max + 1];//计数 数组
        int[] resultArray = new int[arr.length];
        System.arraycopy(arr, 0, resultArray, 0, arr.length);//复制内容
        for (int i = 0; i < arr.length; i++) {//记录出现的次数 countArray 下标代表 arr 中的值
            countArray[arr[i]]++;//下标表示 arr 中的值  countArray中的值 表示出现次数
        }

        /**
         * 对countArray进行循环，对每一个元素countArray[i] = countArray[i] + countArray[i-1]，
         * 目的是统计每一个元素前面有多少个小于它的元素。例如下图countArray[3]的值是4，
         * 那么就代表在array中有4-1个元素小于3。
         */
        for (int i = 1; i < countArray.length; i++) {
            int current = countArray[i];
            int pre = countArray[i - 1];
            countArray[i] = current + pre;//将countArray中的每一个元素变成与前一个元素相加的和
        }

        /**
         * 例如i等于1时，temp[i]值时6，countArray[6]的值是6，也就代表6这个元素前面有5个元素小于小于它，
         * 那么6应该放在array数组的第6个位置也就是array[5]。
         */
        for (int i = 0; i < resultArray.length; i++) {
            int resValue = resultArray[i];
            int countValue = countArray[resValue];
            --countValue;
            arr[countValue] = resultArray[i];//从array的最后一位开始依次放入resultArray中，放入的位置是 --countArray[array[i]]

            count++;
            callback(arr, count);
        }

        finish(arr);
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                throw new RuntimeException("数组中有值小于0");
            if (max < arr[i]) {
                max = arr[i];
            }

        }
        return max;
    }

    @Override
    public String desc() {
        return "不通过比较，计下每个元素的出现次数，统计小于这个元素的个数N，将其放在N位。例如{7，6，2，4，2，3}这个序列，有5个小于7的元素，那么7在排序后应该放在数组的第5位";
    }

    @Override
    public String title() {
        return "计数排序";
    }
}
