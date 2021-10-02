package basic.find;

import basic.generate.IntArray;

/**
 * 递归最大值
 *
 * @author: for-us.cc
 * @date: 2021/10/02
 */
public class MaxValue {

    public static void main(String[] args) {
        int[] values = IntArray.random(10, 100);
        System.out.println(getMax(values, 0, values.length - 1));
    }

    private static int getMax(int[] values, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return values[startIndex];
        }

        int mind = (startIndex + endIndex) / 2;
        int leftMax = getMax(values, startIndex, mind);
        int rightMax = getMax(values, mind + 1, endIndex);

        return Math.max(leftMax, rightMax);
    }
}
