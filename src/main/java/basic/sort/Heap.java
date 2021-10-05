package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static basic.tools.Tools.swap;

/**
 * 堆排序:
 * 完全二叉树：
 * 1. 左孩子：2*i+1
 * 2. 右孩子：2*i+2
 * 3. 父节点：(i-1)/2
 *
 * @author: for-us.cc
 * @date: 2021/10/04
 */
@Slf4j
public class Heap {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);
        heapSort(array);

       log.info("sorted: {}", Arrays.toString(array));
    }

    private static void heapSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        /* 将数据调整为 大根堆 */
        for (int i = 0, len = array.length; i < len; i++) {
            heapInsert(array, i);
        }
        log.info("big root heap: {}", Arrays.toString(array));

        /* 调整大根堆为有序：将最后一个数放在头部作为根，根与其孩子节点进行比较,调整大小位置 */
        int heapSize = array.length;

        /* 最后一个数交换到头部作为根 */
        swap(array, 0, --heapSize);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            swap(array, 0, --heapSize);
        }

    }

    /**
     * 堆下沉，满足父节点大于孩子节点，左孩子小于右孩子
     * @param array
     * @param root
     * @param heapSize 可操作堆的位置 root - heapSize，heapSize表示堆的范围。
     */
    private static void heapify(int[] array, int root, int heapSize) {
        /* 左孩子，右孩子则是 left + 1 */
        int left = 2 * root + 1;
        /* 有孩子节点才调整，完全二叉树首先就是要有左孩子，然后才是右孩子，如果左孩子都没有则 left就是叶子节点，已经到底了 */
        while (left < heapSize) {
            /* 最大的下标值，先两个孩子节点比较出最大者，最后与父节点root节点比较谁最大 */
            int largest = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[root] ? largest : root;
            if (largest == root) {
                /* 最大值就是 root，直接返回不操作 */
                break;
            }

            swap(array, root, largest);
            root = largest;
            left = 2 * root + 1;
        }
    }

    /**
     * 大根堆： 父节点的值比子节点的值大。
     * i 位置上的数与父节点的数进行比较，如果 i 位置比其父节点值大，则将 i 与 父节点互换，然后继续比较，达到大根堆。
     * @param array
     * @param i
     */
    private static void heapInsert(int[] array, int i) {
        /* 当前节点比父节点大，调整当前节点为父节点 */
        while (array[i] > array[(i - 1) / 2]) {
            Tools.swap(array, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

}
