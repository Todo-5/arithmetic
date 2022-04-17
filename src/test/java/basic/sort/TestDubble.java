package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

/**
 * 冒泡排序
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class TestDubble {
    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);
        dubble(array);

        log.info("sorted: {}", array);
    }

    private static void dubble(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0, len = array.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[i] > array[j]) {
                    Tools.swap(array, i, j);
                }
            }
        }
    }
}
