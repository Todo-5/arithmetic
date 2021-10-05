package basic.sort;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static basic.tools.Tools.swap;

/**
 * 快速排序:
 * 将数组中的最后一个数作为 mid，
 * 1. 小于mid：放在左边。
 * 2. 等于mid：放在中间。
 * 3. 大于mid：放在右边。
 * 依次分治递归求解。
 *
 *
 * Hit：
 * 1.当数据状况是 【1，2，3，4，5】有序时，mid = 5，导致缺少另一半的递归求解，因此时间复杂度为 O(N^2)，空间复杂度为O(N^2)。
 * 2.空间复杂度产生于 partition，需要记录 等于mid的边界。
 *
 * 因此将最后一个数 mid，随机从数据中抽取来打乱数据状态，随机 mid = 3时，时间复杂度<b>期望</b>是O(nlogN)，空间复杂度是O(nlogN)。
 *
 *
 * @author: for-us.cc
 * @date: 2021/10/04
 */
@Slf4j
public class Quick {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 50);
        quick(array);

        log.info("sorted: {}", Arrays.toString(array));
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

        /* 将末尾R的数，随机与数组中的某个数进行交换，将典型快排转化为随机快排 */
        swap(array, L + (int) (Math.random() * (R - L + 1)), R);

        /* 划分区域（小于X；等于X；大于X） */
        int[] point = partition(array, L, R);
        quick(array, L, point[0] - 1);
        quick(array, point[1] + 1, R);
    }

    private static int[] partition(int[] array, int L, int R) {
        int less = L - 1;
        int more = R;

        while (L < more) {
            if (array[L] < array[R]) {
                swap(array, ++less, L++);
            } else if (array[L] > array[R]) {
                swap(array, L, --more);
            } else {
                L++;
            }
        }
        swap(array, more, R);
        return new int[] {less + 1, more};
    }
}
