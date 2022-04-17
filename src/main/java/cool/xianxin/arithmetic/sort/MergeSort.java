package cool.xianxin.arithmetic.sort;

/**
 * 归并排序
 *
 * @author xianxin.cool
 */
public class MergeSort {

    /**
     * 拆分子问题，并分别排序 merge（A，p，q，r）。将有序地[p, q]和[p+1, r]进行合并。
     *
     * @param array
     */
    public static void sort(int[] array) {
        recursionMerge(array, 0, array.length - 1);
    }

    /**
     * 递归合并
     * @param array 数组
     * @param left 左下标
     * @param end 右下标
     */
    private static void recursionMerge(int[] array, int left, int end) {
        /* 递归终止条件 */
        if (left >= end) {
            return;
        }

        int mid = (left + end) / 2;

        /* 处理子问题 */
        recursionMerge(array, left, mid);
        recursionMerge(array, mid + 1, end);

        /* 合并子问题的解 */
        merge(array, left, mid, end);
    }

    /**
     * 合并[left,mid]和[mid+1,end]两个有序数组
     * @param array 数组
     * @param left 左
     * @param mid 中
     * @param end 右
     */
    private static void merge(int[] array, int left, int mid, int end) {
        /* 辅助数组用于存储排序的元素 */
        int[] help = new int[end - left + 1];
        int h = 0;

        /* 两个数组比较大小，按照小到大排序 */
        int i = left, j = mid + 1;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                help[h++] = array[i++];
            } else {
                help[h++] = array[j++];
            }
        }

        while (i <= mid) {
            help[h++] = array[i++];
        }
        while (j <= end) {
            help[h++] = array[j++];
        }

        h = 0;
        while (left <= end) {
            array[left++] = help[h++];
        }
    }

}
