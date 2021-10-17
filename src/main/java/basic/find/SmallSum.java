package basic.find;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 小数和问题
 *
 * 在一个数组中，每一个元素左边比当前元素值小的元素值累加起来，叫做这个数组的小和
 *  例如：[2,3,4,1,5]
 *  2左边比2小的元素：无
 *  3左边比3小的元素：2
 *  4左边比4小的元素：2，3
 *  1左边比1小的元素：无
 *  5左边比5小的元素：2,3,4,1
 *  小和small_sum = 2 + 2 + 3 + 2 + 3 + 4 + 1 = 17
 *
 * @author: for-us.cc
 * @date: 2021/10/03
 */
@Slf4j
public class SmallSum {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);

        /* 完全正确的答案 correctSum */
        int[] copyArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copyArr[i] = array[i];
        }
        int correctSum = testComparator(copyArr);

        /* 待验证的方法 */
        int sum = smallSum(array);
        log.info("sum: {}, {}", correctSum, sum);
    }

    public static int smallSum(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        return mergeSort(array, 0, array.length - 1);
    }

    private static int mergeSort(int[] array, int L, int R) {
        if (L == R) {
            return 0;
        }

        int mid = L + ((R - L) >> 1);
        /* 分治左部分小数和 + 分治右部分小数和 + merge合并的小数和 */
        return mergeSort(array, L, mid) + mergeSort(array, mid + 1, R) + merge(array, L, mid, R);
    }

    private static int merge(int[] array, int L, int mid, int R) {
        int[] values = new int[R - L + 1];
        int pL = L;
        int pR = mid + 1;
        int index = 0;
        int sum = 0;

        while (pL <= mid && pR <= R) {
            /*
             * 两边都是有序的，当左边某个数 a 小于右边的某个数 b，则表示 b及b后面的数都比 a大
             *，那么对于 a而言，存在 b及b后面的数都有一个 小数a作为和
             */
            sum += array[pL] < array[pR] ? (R - pR + 1) * array[pL] : 0;
            values[index++] = array[pL] < array[pR] ? array[pL++] : array[pR++];
        }

        while (pL <= mid) {
            values[index++] = array[pL++];
        }
        while (pR <= R) {
            values[index++] = array[pR++];
        }
        for (int i = R; i >= L ; i--) {
            array[i] = values[--index];
        }

        return sum;
    }

    /**
     * 完全正确的方法
     * @param arr
     * @return
     */
    public static int testComparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }
}