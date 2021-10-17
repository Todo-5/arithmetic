package basic.other;

/**
 * 之字形打印矩阵
 *
 * 采用两个指针来标记两个 point，两点之间连接一条线进行打印，并通过一个标志位来确定从哪个方向（上或下）打印数据
 *  pointA：一直向右走，到底时向下走。
 *  pointB：一直向下走，到底时向右走。
 *
 *  每次pointA和pointB各走一步，当pointA和pointB在下一个点重合时到达末尾
 *
 * @author: for-us.cc
 * @date: 2021/10/16
 */
public class 之字形矩阵打印 {

    public static void main(String[] args) {
        int[][] values = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        };

        printZhi(values);
    }

    private static void printZhi(int[][] values) {
        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endR = values.length - 1;
        int endC = values[0].length - 1;
        boolean upBool = false;

        while (aR != endR + 1) {
            printLevel(values, aR, aC, bR, bC, upBool);

            /* 向右到底后向下 ，注意先处理 aR避免 aC+1导致判断错误 */
            aR = aC == endC ? aR + 1 : aR;
            aC = aC == endC ? aC : aC + 1;
            /* 向下到底后向右 */
            bC = bR == endR ? bC + 1 : bC;
            bR = bR == endR ? bR : bR + 1;

            upBool = !upBool;
        }
    }

    /**
     * 打印两个点之间连线的数据项
     * @param values
     * @param aR
     * @param aC
     * @param bR
     * @param bC
     * @param upBool 是否从上向下打印
     */
    private static void printLevel(int[][] values, int aR, int aC, int bR, int bC, boolean upBool) {
        if (upBool) {
            while (aR != bR + 1) {
                System.out.print(values[aR++][aC--] + " ");
            }
        } else {
            while (bR != aR - 1) {
                System.out.print(values[bR--][bC++] + " ");
            }
        }

        System.out.println();
    }
}
