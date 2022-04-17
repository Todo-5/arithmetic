package cool.xianxin.arithmetic.sort;

/**
 * 选择排序
 *
 * @author xianxin.cool
 */
public class SelectionSort {

    /**
     * 在列表中逐步选择最小的值，依次放置在前列
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {

            /* 默认一个为最小值 */
            int minValue = array[i];
            int minIndex = i;

            /* 找到最小值 */
            for (int j = i + 1; j < array.length; j++) {
                if (minValue > array[j]) {
                    minValue = array[j];
                    minIndex = j;
                }
            }

            /* 交换最小值到前列 */
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
