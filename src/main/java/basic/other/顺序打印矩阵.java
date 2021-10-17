package basic.other;

/**
 * 顺序打印矩阵
 *
 *
 *   ────────►
 *   1 2 3 4 │
 *           │
 * ┌►5 6 7 8 │
 * │         │
 * │ 9 A B C │
 * ◄─────────▼
 *
 * 打印：1 2 3 4 8 C B A 9 5 6 7
 *
 * @author: for-us.cc
 * @date: 2021/10/16
 */
public class 顺序打印矩阵 {

    public static void main(String[] args) {
        int[][] values = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        /* 对每一个矩形分别进行打印 */
        int aR = 0;
        int aC = 0;
        int bR = values.length - 1;
        int bC = values[0].length - 1;
        while (aR <= bR && aC <= bC) {
            printMatrix(values, aR++, aC++, bR--, bC--);
        }
    }

    /**
     * 打印两点对角线形成的矩形
     *
     * @param values
     * @param aR 左上角行
     * @param aC 左上角列
     * @param bR 右下角行
     * @param bC 右下角列
     */
    private static void printMatrix(int[][] values, int aR, int aC, int bR, int bC) {
        /* 位于同一行上 */
        if (aR == bR) {
            for (int i = aC; i <= bC; i++) {
                System.out.print(values[aR][i] + " ");
            }
            return;
        }
        /* 位于同一列上 */
        if (aC == bC) {
            for (int i = aR; i <= bR; i++) {
                System.out.printf(values[i][aC] + " ");
            }
            return;
        }

        /* 形成矩形 */
        int c = aC;
        int r = aR;
        /* 矩形上 */
        while (c < bC) {
            System.out.printf(values[aR][c++] + " ");
        }
        /* 矩形右*/
        while (r < bR) {
            System.out.printf(values[r++][bC] + " ");
        }
        /* 矩形下 */
        while (c > aC) {
            System.out.printf(values[bR][c--] + " ");
        }
        /* 矩形左 */
        while (r > aR) {
            System.out.printf(values[r--][aC] + " ");
        }
    }

}
