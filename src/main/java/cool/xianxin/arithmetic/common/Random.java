package cool.xianxin.arithmetic.common;

import lombok.extern.slf4j.Slf4j;

/**
 * 随机类
 *
 * @author xianxin.cool
 */
@Slf4j
public class Random {

    /**
     * 生成 size个随机数组
     *
     * @param size 数组个数
     * @return 随机数组
     */
    public static int[] random(int size) {
        java.util.Random r = new java.util.Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(100_000) * (r.nextInt() % 4 == 0 ? -1 : 1);
        }
        return array;
    }
}
