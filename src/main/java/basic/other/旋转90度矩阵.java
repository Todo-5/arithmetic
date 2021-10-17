package basic.other;

/**
 * 旋转90度矩阵，必须是正方形，非正方形旋转90°会改变数据格式
 *
 * 1 2 3
 * 4 5 6
 * 7 8 9
 *
 * 转换成
 * 7 4 1
 * 8 5 2
 * 9 6 3
 *
 * @author: for-us.cc
 * @date: 2021/10/16
 */
public class 旋转90度矩阵 {

    public static void main(String[] args) {
        int[][] values = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int aR = 0;
        int aC = 0;
        int bR = values.length - 1;
        int bC = values.length - 1;
        while (aR <= bR && aC <= bC) {
            rotateMatrix(values, aR++, aC++, bR--, bC--);
        }
        printMatrix(values);
    }

    /**
     * 翻转矩阵
     *
     * 主要处理正方形的四个角之间的位置调整，然后借助 int i 来处理下一组四个点的位置即可。
     *
     * @param values
     * @param aR
     * @param aC
     * @param bR
     * @param bC
     */
    private static void rotateMatrix(int[][] values, int aR, int aC, int bR, int bC) {
        int times = bC - aC;
        int val;
        for (int i = 0; i < times; i++) {
            val = values[aR][aC + i];
            /* 口，左上角点 */
            values[aR][aC + i] = values[bR - i][aC];
            /* 口，左下角点 */
            values[bR - i][aC] = values[bR][bC - i];
            /* 口，右下角点 */
            values[bR][bC - i] = values[aR + i][bC];
            /* 口，右上角点 */
            values[aR + i][bC] = val;
        }
    }

    private static void printMatrix(int[][] values) {
        for (int i = 0, row = values.length; i < row; i++) {
            for (int j = 0, col = values[i].length; j < col; j++) {
                System.out.printf(values[i][j] + " ");
            }
            System.out.println();
        }
    }
}
