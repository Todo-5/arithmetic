package basic.sort;

import basic.generate.IntArray;

import java.util.Arrays;

import static basic.tools.Tools.swap;

/**
 * 插入排序
 *
 * @author: for-us.cc
 * @date: 2021/10/02
 */
public class Insert {

    public static void main(String[] args) {
        int[] array = IntArray.random(100, 1_000);
        insert(array);
        System.out.println(array);
    }

    private static void insert(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1, len = array.length; i < len; i++) {
            /**
             *  由大向小（后）进行匹配，依次交换
             *  0, 1, 3, 5, 2
             *           <-2
             *  0, 1, 3, 2, 5  交换一次
             *        <-2
             *  0, 1, 2, 3, 5  交换一次
             */
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; j--) {
                swap(array, j, j + 1);
            }
        }
    }
}
