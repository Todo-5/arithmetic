package basic.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 将最小的放在 array[0] 处，次小的放在 array[1]处.....
 * @author: for-us.cc
 * @date: 2021/10/02
 */
public class Select {

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 2, 7, 22, 33, 11, 12, 55, 23, -1};
        select(array);
        System.out.println(Arrays.toString(array));
    }

    private static void select(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0, len = array.length; i < len; i++) {
            int min = i;
            /* 找到 j ~ len 中最小的值。 */
            for (int j = i + 1; j < len; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            /* i 不是最小值，则转换 */
            if (i != min) {
                swap(array, i, min);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int stat = array[i];
        array[i] = array[j];
        array[j] = stat;
    }
}
