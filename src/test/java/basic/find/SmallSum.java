package c;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 小和
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class SmallSum {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);

        int[] copyOf = Arrays.copyOf(array, array.length);
        int rightSum = basic.find.SmallSum.smallSum(copyOf);
        int sum = smallSum(array);
        log.info("sum: {}, right: {}", sum, rightSum);
    }

    private static int smallSum(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        return smallSum(array, 0, array.length - 1);
    }

    private static int smallSum(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        return smallSum(array, L, mid) + smallSum(array, mid + 1, R) + meger(array, L, mid, R);
    }

    private static int meger(int[] array, int L, int mid, int R) {
        int[] values = new int[R- L + 1];
        int pL = L;
        int pR = mid + 1;
        int index = 0;
        int sum = 0;

        while (pL <= mid && pR <= R) {
            sum += array[pL] <= array[pR] ? (R - pR + 1) * array[pL] : 0;

            values[index++] = array[pL] < array[pR] ? array[pL++] : array[pR++];
        }

        while (pL <= mid) {
            values[index++] = array[pL++];
        }
        while (pR <= R) {
            values[index++] = array[pR++];
        }

        for (int i = R; i >= L; i--) {
            array[i] = values[--index];
        }

        return sum;
    }
}
