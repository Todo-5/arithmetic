package basic.find;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 数之间最大的差值
 *
 * 借鉴桶排序的思想，存在N个数，则创建N+1个数的数组max、min、exist来记录每个桶中的最大、最小、是否存在等三个信息。
 * 目的是为了排除最大差距的两个数一定不在同一个桶中，因为N+1个桶，必然有一个空桶。
 * 1. 准备三个N+1长度的数组 max、min、hasNum记录每个桶中的最大值、最小值、是否为空桶,0号桶存储最小值，N号桶存储最大值。
 * 2. 循环遍历 N，并为数组 max、min、hasNum设置相关的数据值。
 * 3. 设置全局变量 result记录最大间距。
 * 4. 遍历循环 N，通过数组 max、min、hasNum 来求解每个桶之间的最大值（当前桶的最小值 - 上一个桶的最大值），并赋值给 result，依次得到最终的最大差值。
 *
 * @author: for-us.cc
 * @date: 2021/10/05
 */
@Slf4j
public class MaxGrap {

    public static void main(String[] args) {
        int[] array = IntArray.random(110, 3550);
        int maxGrap = maxGrap(array);
        log.info("grap: {}", maxGrap);
    }

    private static int maxGrap(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }

        /* 设置 0号桶最小值，N号桶最大值 */
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0, len = array.length; i < len; i++) {
            min = Math.min(array[i], min);
            max = Math.max(array[i], max);
        }
        if (min == max) {
            /* 最小值和最大值一样，只存在一个数 */
            return 0;
        }

        int[] mins = new int[array.length + 1];
        int[] maxs = new int[array.length + 1];
        boolean[] hasNum = new boolean[array.length + 1];
        int bid;
        for (int i = 0, len = array.length; i < len; i++) {
             /* 计算array[i]位于哪个桶 */
            bid = bucket(array[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(array[i], mins[bid]) : array[i];
            maxs[bid] = hasNum[bid] ? Math.max(array[i], maxs[bid]) : array[i];
            hasNum[bid] = true;
         }

        /* 计算最大差值： 桶的最小值 - 上一个桶的最大值 */
        int result = 0;
        int preMax = maxs[0];
        for (int i = 1, len = array.length + 1; i < len; i++) {
            if (hasNum[i]) {
                result = Math.max(result, mins[i] - preMax);
                preMax = maxs[i];
            }
        }
        return result;
    }

    /**
     * 假设num应该存放的桶为x，则存在表达式： min+x*(max-min)/len=num  ==> x=(num-min)*len/(max-min)
     * <pre>
     *     数据【0，2，3，4，5】
     *      - (max - min) / len：表示一个桶存储数据的范围，如（5-0）/5 = 1，代表一个桶中存储 范围1的数，为【0，1)...(4,5】
     * </pre>
     * @param num
     * @param len
     * @param min
     * @param max
     * @return
     */
    private static int bucket(int num, int len, int min, int max) {
        return (num - min) * len / (max - min);
    }
}
