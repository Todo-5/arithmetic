package cool.xianxin.arithmetic.sort;

/**
 * 冒泡排序
 *
 * @author xianxin.cool
 */
public class BubbleSort {

    /**
     * 不断地比较相邻的连个数，将小于的数放在左侧。
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            /* 每次从最后往前进行比较，比较到 i 即可，因为 i之前的都是已经是有序的 */
            for (int j = array.length - 1; j > i ; j--) {

                /* 比较相邻的两个数，小的放左侧 */
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
