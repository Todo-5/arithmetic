package basic.generate;

/**
 * 随机数
 *
 * @author: for-us.cc
 * @date: 2021/11/01
 */
public class IntValue {

    public static int generateValue(int maxValue) {
        return (int) (Math.random() * maxValue + 1);
    }

}
