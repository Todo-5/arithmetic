package cool.xianxin.arithmetic.sort;

/**
 * 快速排序，以末尾数作为参考，划分为 《= 和 >= 两个区域。核心就是将范围的末位数放在正确的位置上。
 * @author xianxin.cool
 */
public class QuickSort {

    /**
     * 排序
     * @param array
     */
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 快速排序
     * @param array
     * @param start
     * @param end
     */
    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            /* 以array[end]作为参考划分两部分区域 */
            int mid = partition(array, start, end);

            /* 继续求解子问题 */
            quickSort(array, start, mid - 1);
            quickSort(array, mid + 1, end);
        }
    }

    /**
     * 以最后一位作为 参考 X，从 start 开始比较，将大于 X 值的放在 X的后面
     * @param array
     * @param start
     * @param end
     * @return 本次排好序的下标值
     */
    private static int partition(int[] array, int start, int end) {
        int refer = array[end];
        /* less代表小于等于 refer 的指针，一开始没有则为 start-1  */
        int less = start - 1;

        for (int i = start; i < end; i++) {

            /* array[i]位于左侧的值，左侧位置由 less + 1 提供（因为 less+1 是大于 refer的） */
            if (array[i] <= refer) {
                less++;

                int temp = array[i];
                array[i] = array[less];
                array[less] = temp;
            }
        }

        /* 还剩下参考位array[end]，此时 array[less] <= refer，refer所处的有序位置是 less + 1，位置由最后一位 end 提供 */
        int temp = array[end];
        array[end] = array[less + 1];
        array[less + 1] = temp;

        return less + 1;
    }
}
