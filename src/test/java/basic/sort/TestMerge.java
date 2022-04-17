package basic.sort;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 归并
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class TestMerge {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);

        mergeSort(array);

        log.info("sort: {}", array);
    }

    private static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int L, int R) {
        if (L == R) {
            return;
        }

        int mid = (L + R) / 2;
        mergeSort(array, L, mid);
        mergeSort(array, mid + 1, R);

        merge(array, L, mid, R);
    }

    private static void merge(int[] array, int L, int mid, int R) {
        int pL = L;
        int pR = mid + 1;
        int i = 0;

        int[] values = new int[R - L + 1];
        while(pL <= mid && pR <= R) {
            values[i++] = array[pL] <= array[pR] ? array[pL++] : array[pR++];
        }

        while(pL <= mid) {
            values[i++] = array[pL++];
        }
        while (pR <= R) {
            values[i++] = array[pR++];
        }


        while (i > 0) {
            array[R--] = values[--i];
        }
    }
}
