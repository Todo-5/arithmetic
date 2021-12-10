package basic.find;

/**
 * 有序矩阵查找数值是否存在
 * <p>
 * 1 4 5
 * 2 5 7
 * 3 5 8
 * <p>
 * 查找是否存在一个2.
 * 由于数据项是有序的（左小右大，上小下大），因此可以先从最后开始找
 * - 5比2大，下面的（7 8）排除，向左移动
 * - 4比2大，下面的（5 5）排除，向左移动
 * - 1比2小，向下移动
 * <p>
 * hit：大致思路就是如此，可以从四个角四个方式去判断
 *
 * @author: for-us.cc
 * @date: 2021/10/17
 */
public class 有序矩阵查找 {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 3, 4, 5, 6},// 0
                {10, 12, 13, 15, 16, 17, 18},// 1
                {23, 24, 25, 26, 27, 28, 29},// 2
                {44, 45, 46, 47, 48, 49, 50},// 3
                {65, 66, 67, 68, 69, 70, 71},// 4
                {96, 97, 98, 99, 100, 111, 122},// 5
                {166, 176, 186, 187, 190, 195, 200},// 6
                {233, 243, 321, 341, 356, 370, 380} // 7
        };
        int K = 233;
        System.out.println(isContains(matrix, K));
    }

    /**
     * 判断一个值 k 是否存在有序矩阵中
     *
     * @param matrix
     * @param k
     * @return
     */
    private static boolean isContains(int[][] matrix, int k) {
        int row = 0;
        int col = matrix[0].length - 1;
        int maxRow = matrix.length;
        /* 从右上角开始判断：边界，col向左移动 - ，row向下移动 + */
        while (col > -1 && row < maxRow) {
            if (matrix[row][col] == k) {
                return true;
            } else if (matrix[row][col] < k) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

}
