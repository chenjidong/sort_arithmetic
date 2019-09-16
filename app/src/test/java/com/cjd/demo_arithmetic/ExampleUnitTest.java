package com.cjd.demo_arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        int[] array = {1, 14, 7, 11, 2, 67, 5, 4};
        int[] result = quickSort(array);
        System.out.println(result.toString());
        assertEquals(4, 2 + 2);
    }

    public static int[] quickSort(int[] array) {

        sort(array, 0, array.length - 1);
        return array;
    }

    public static void sort(int[] array, int left, int right) {
        if (left > right)
            return;
        int base = array[left];
        int i = left, j = right;
        while (i != j) {

            //先计算右边
            while (array[j] >= base && i < j) {
                j--;
            }
            //计算左边
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            System.out.println("i:" + i + " j:" + j);
            if (i < j) {
                int temp = array[j];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);

    }

    public static int[] shellSort(int[] array) {

        int len = array.length;//8
        int temp, gap = len / 2;//4
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];//2
                int preIndex = i - gap;//0
                while (preIndex >= 0 && array[preIndex] < temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {

        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];//7
            int preIndex = i;//1 默认第一个已排序
            while (preIndex >= 0 && current < array[preIndex]) {//14
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex + 1] = current;
        }

        return array;
    }

    /**
     * 选择排序 每次比较 获取最小的排在前面
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

        }
        return array;
    }

    /**
     * 冒泡排序 比较相邻的元素  大于就交换
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            System.out.println("--->i:" + array[i]);
            StringBuilder builder = new StringBuilder();
            //-i 每次for 最后一个已经不需要比较 j != i 是因为不能保证第一是最小的
            for (int j = 0; j < array.length - 1 - i; ++j) {
                builder.append(array[j]).append(":");

                int value = array[j];
                int next = array[j + 1];
                if (next < value) {
                    array[j + 1] = value;
                    array[j] = next;
                }
                System.out.println(array[j]);

            }
            System.out.println(builder.toString());
        }
        return array;
    }
}