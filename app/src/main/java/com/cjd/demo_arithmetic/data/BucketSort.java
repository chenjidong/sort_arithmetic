package com.cjd.demo_arithmetic.data;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author chenjidong
 * @data 2019/9/18.
 * @Description:
 **/
public class BucketSort extends BaseSort {
    int count = 0;

    @Override
    public void sort(int[] arr) {
        count = 0;
        int max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - min) / arr.length;
            bucketArr.get(index).add(arr[i]);
        }

        //对每个桶进行排序 可选 冒泡 选择 插入 等都可以使用
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        ArrayList<Integer> arrays = new ArrayList<>();
        for (int i = 0; i < bucketArr.size(); i++) {
            ArrayList<Integer> item = bucketArr.get(i);
            arrays.addAll(item);
        }

        int[] array = new int[arrays.size()];
        for (int i = 0; i < arrays.size(); i++) {
            array[i] = arrays.get(i);
        }

        finish(array);
    }

    @Override
    public String desc() {
        return "桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排";
    }

    @Override
    public String title() {
        return "桶排序";
    }
}
