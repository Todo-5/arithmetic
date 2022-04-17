package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

/**
 * 插入排序
 *
 * @author: for-us.cc
 * @date: 2021/10/06
 */
@Slf4j
public class TestInsert {

    public static void main(String[] args) {
        int[] array = IntArray.random(10, 20);
        insert(array);

        log.info("sort: {}", array);
    }

    private static void insert(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 1, len = array.length; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[j + 1]) {
                    Tools.swap(array, j, j + 1);
                }
            }
        }
    }
}
