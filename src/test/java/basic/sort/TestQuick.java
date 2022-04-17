package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

/**
 * 快排
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class TestQuick {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);
        quick(array);
        log.info("sort: {}", array);
    }

    private static void quick(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        quick(array, 0, array.length - 1);
    }

    private static void quick(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }

        /* 求取 last value 的大小边界 */
        int[] point = partition(array, L, R);
        quick(array, L, point[0] - 1);
        quick(array, point[1] + 1, R);
    }

    private static int[] partition(int[] array, int L, int R) {
       int less = L - 1;
       int more = R;

       while (L < more) {
           if (array[L] < array[R]) {
               Tools.swap(array, ++less, L++);
           } else if (array[L] > array[R]) {
               Tools.swap(array, --more, L);
           } else {
               L++;
           }
       }

       Tools.swap(array, more, R);
       return new int[] {less + 1, more};
    }
}
