package cool.xianxin.arithmetic.sort;

/**
 * 插入排序
 *
 * @author xianxin.cool
 */
public class InsertionSort {

    /**
     * 将 i 元素存放到有序列队中，选择一个插入点 index，然后将 index之后的元素后移
     * 1,3,3,4
     *        ,2
     * 每次比较都进行判断，如果小则交换两者位置 1，3，3，[2]，4
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int current = array[i];

            int j = i;
            while (j > 0 && current < array[j - 1]) {
                /* 如果当前值小于前一个值，则后移 */
                array[j] = array[j - 1];
                j--;
            }

            array[j] = current;
        }
    }

}
