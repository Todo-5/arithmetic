package cool.xianxin.arithmetic.sort;

/**
 * 堆排序
 *
 * 1. 建立大根堆，目的是为了让前 n/2-1 个根节点都是整个数组中最大的，且array[0]一定是最大值
 * 2. 通过堆下层，将 qrray[0]和array[n]互换，直接排序一个最大值到数组末尾。
 * 3. 接下来需要重新调整[0, n-1]为最大根，即 array[0]一定是次大的。
 * 堆排序的核心就是 array[0]永远是最大值，直接与末尾元素替换，从 [n...1]逆序排。
 *
 * @author xianxin.cool
 */
public class HeapSort {

    /**
     * 1. 首先需要构建一个大根堆
     *      一个数组中，前 n / 2 个元素都是页节点（向下取整），如 0，1，2，叶子节点就是 n/2 始。
     * 2. 将末尾元素 n-i 与 array[0] 进行交换，然后比较子树，最后放置在末尾 n - i
     * 3. 调整大根堆 [0, n - i]
     * @param array
     */
    public static void sort(int[] array) {
        /* 构建大根堆 */
        buildMaxHeap(array);

        for (int i = array.length - 1; i > -1 ; i--) {
            /* 将末位元素与array[0]互换，则排序好一位 */
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            /* 调整最大堆 */
            maxHeapify(array, i, 0);
        }
    }

    /**
     * 构建大根堆，一共有 n/2-1 个根节点，从最后一个节点去构建最大堆，
     * @param array
     */
    private static void buildMaxHeap(int[] array) {
        /* 从末非叶子节点开始往前调整最大堆 */
        for (int i = array.length / 2 - 1; i > -1; i--) {
            maxHeapify(array, array.length, i);
        }
    }

    /**
     * 调整最大堆，root不是最大时需要交换根节点，但交换根节点后可能其子节点不满足最大堆，因此需要进行调整
     * @param array
     * @param len 调整的最大堆范围长度，
     * @param root
     */
    private static void maxHeapify(int[] array, int len, int root) {
        /* 左右孩子，默认最大值是当前根节点 */
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int max;

        /* 有左孩子，与root比大 */
        if (left < len && array[left] > array[root]) {
            max = left;
        } else {
            max = root;
        }
        /* 有右孩子，与max{left，root}比大 */
        if (right < len && array[right] > array[max]) {
            max = right;
        }

        /* 判断最大值，如果root不是最大值，则需要调整成大根堆 */
        if (max != root) {
            /* 将最大值放在array[root]中*/
            int temp = array[root];
            array[root] = array[max];
            array[max] = temp;

            /* 被调整的子节点坐标 max 可能不满足最大堆，因此需要调整 */
            maxHeapify(array, len, max);
        }
    }
}
