package basic.sort;

import basic.generate.IntArray;
import basic.tools.Tools;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 冒泡排序
 * 两者位置之间相互比较（i 和 i+1）
 *
 * @author: for-us.cc
 * @date: 2021/10/02
 */
@Slf4j
public class Bubble {

    public static void main(String[] args) {
        int[] array = IntArray.random(100, 1_000);
        new Bubble().sort(array);

        log.info("sort: {}", array);
    }

    private void sort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int end = array.length - 1; end > 0; end--) {
            for (int i = 0; i < end; i++) {
                /* 相邻位置进行匹配 */
                if (array[i] > array[i + 1]) {
                    Tools.swap(array, i, i + 1);
                }
            }
        }
    }
}
