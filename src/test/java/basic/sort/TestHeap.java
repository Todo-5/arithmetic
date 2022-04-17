package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

/**
 * 堆排序
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class TestHeap {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);
        heap(array);
        log.info("sort: {}", array);
    }

    private static void heap(int[] array) {
        if (array ==  null || array.length < 2) {
            return;
        }

        /* 调整最大堆 */
        for (int i = 0, len = array.length; i < len; i++) {
            heapInsert(array, i);
        }

        /* 调整 */
        int heapSize = array.length;
        Tools.swap(array, 0, --heapSize);
        while (heapSize > 0) {
            heapify(array, 0, heapSize);
            Tools.swap(array, 0, --heapSize);
        }
    }

    private static void heapify(int[] array, int root, int heapSize) {
        int left = 2 * root + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            largest = array[largest] > array[root] ? largest : root;

            if (root == largest) {
                break;
            }

            Tools.swap(array, root, largest);
            root = largest;
            left = 2 * root + 1;
        }
    }

    private static void heapInsert(int[] array, int i) {
        while (array[i] > array[(i - 1) / 2]) {
            Tools.swap(array, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
}
