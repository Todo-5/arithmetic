package basic.generate;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 生成数组
 *
 * @author: for-us.cc
 * @date: 2021/10/02
 */
@Slf4j
public class IntArray {

    /**
     * 随机生成一组数据，最大值为maxValue
     *
     * @param size
     * @param maxValue
     * @return
     */
    public static int[] random(int size, int maxValue) {
        int[] value = new int[size];
        for (int i = 0; i < size; i++) {
            value[i] = generateValue(maxValue);
        }

        log.info("random int array value：{}", Arrays.toString(value));
        return value;
    }

    /**
     * 随机生成有序步长的 int 数组
     * @param size 最大个数
     * @param maxStep
     * @return
     */
    public static int[] randomStepOrder(int size, int maxStep) {
        int[] value = new int[size];
        int val = 0;
        for (int i = 0; i < size; i++) {
            int step = generateValue(maxStep);
            value[i] = val + step;
        }

        log.info("random step order int array value:{}", Arrays.toString(value));
        return value;
    }

    private static int generateValue(int maxValue) {
        return (int) (Math.random() * maxValue + 1);
    }
}
