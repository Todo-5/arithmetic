package basic.other;

import basic.generate.IntArray;
import lombok.extern.slf4j.Slf4j;

/**
 * 数组队列，数组作为队列而言是循环地队列。
 *
 * @author: for-us.cc
 * @date: 2021/10/07
 */
@Slf4j
public class ArrayQueue {

    Integer[] values;
    int size = 0;
    int head = 0;
    int end = 0;

    public ArrayQueue(int initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("init size less than 0");
        }
        values = new Integer[initSize];
    }

    public void push(Integer value) {
        if (size > values.length) {
            throw new IndexOutOfBoundsException("队列已满");
        }

        values[end] = value;
        size++;
        end = end + 1 == values.length ? 0 : end + 1;
    }

    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("数组为空");
        }
        Integer val = values[head];
        size--;
        head = head + 1 == values.length ? 0 : head + 1;

        return val;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        int[] random = IntArray.random(10, 200);
        for (int i = 0; i < random.length; i++) {
            queue.push(random[i]);
        }

        for (int i = 0; i < random.length; i++) {
            log.info("{}",queue.pop());
        }
    }
}
