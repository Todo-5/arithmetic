package cool.xianxin.arithmetic.sort;

import cool.xianxin.arithmetic.common.Random;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 排序算法测试
 *
 * @author xianxin.cool
 */
@Slf4j
public class TestSort {

    public static void main(String[] args) {
        java.util.Random r = new java.util.Random();
        int times = r.nextInt(100_000);
        log.info("判断次数：{}", times);

        while (times-- > 0) {
            int[] random = Random.random(r.nextInt(100));
            int[] copyRandom = Arrays.copyOf(random, random.length);

            QuickSort.sort(random);
            Arrays.sort(copyRandom);

            if (!TestSort.equals(random, copyRandom)) {
                System.out.println("排序错误！");
                break;
            }
        }
    }

    /**
     * 判断两个集合是否相等
     * @param a 数组
     * @param b 数组
     * @return true相等
     */
    public static boolean equals(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
