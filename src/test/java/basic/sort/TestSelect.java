package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

/**
 * 选择排序
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class TestSelect {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);
        select(array);

        log.info("sort: {}", array);
    }

    private static void select(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0, len = array.length; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            Tools.swap(array, min, i);
        }
    }
}
