package basic.tools;

/**
 * 工具类
 *
 * @author: for-us.cc
 * @date: 2021/10/05
 */
public class Tools {

    public static final void swap(int[] array, int i, int j) {
        int stat = array[i];
        array[i] = array[j];
        array[j] = stat;
    }
}
