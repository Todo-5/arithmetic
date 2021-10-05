package basic.sort;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 归并排序： 对已有序的两个数组进行比对，通过一个辅助数组存放两个数组的排序数据。
 * 1. 定义一个辅助数组。
 * 2. 将待排序数组拆分成两个部分 arr1 和 arr2.
 * 3. 将两个数组分别按照从小到大的方式进行排序。
 * 4. 两数组依次比对，小的放在辅助数组中，直到某一方数组至末尾，然后将另一个数组中剩余的数据放在辅助数组中。
 *
 * @author: for-us.cc
 * @date: 2021/10/03
 */
@Slf4j
public class Merge {

    public static void main(String[] args) {
        int[] array = IntArray.random(11, 100);
        mergerSort(array);
        log.info("sorted: {}", Arrays.toString(array));
    }

    private static void mergerSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        mergerSort(array, 0, array.length - 1);
    }

    private static void mergerSort(int[] array, int L, int R) {
        if (L == R) {
            return;
        }

        /* 拆分两个数组进行排序 */
        int mid = (L + R) / 2;
        mergerSort(array, L, mid);
        mergerSort(array, mid + 1, R);

        /* 将排序后的两个数组进行合并 */
        merger(array, L, mid, R);
    }

    /**
     * 将区间为 [L, mid] 和 [mid + 1, R]的有序数据进行合并
     *
     * @param array
     * @param L
     * @param mid
     * @param R
     */
    private static void merger(int[] array, int L, int mid, int R) {
        /* 定义一个辅助数组来存放比对的数据 */
        int[] values = new int[R - L + 1];

        /* 比对 */
        int index = 0;
        int pL = L;
        int pR = mid + 1;
        while (pL <= mid && pR <= R) {
            values[index++] = array[pL] > array[pR] ? array[pR++] : array[pL++];
        }

        /* 移动没有匹配完的数组数据 */
        while (pL <= mid) {
            values[index++] = array[pL++];
        }
        while (pR <= R) {
            values[index++] = array[pR++];
        }

        /* 将辅助数据中有序的数据依次copy到原数组中 */
        for (int i = R; i >= L; i--) {
            array[i] = values[--index];
        }
    }

}
