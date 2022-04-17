package basic.other;

import basic.generate.IntValue;

/**
 * 打印公共部分的两个链表节点值
 * 参考归并排序的merge操作，依次从listA和listB的最小位置处开始比对，相等就打印
 *
 * @author: for-us.cc
 * @date: 2021/10/17
 */
public class 两个有序链表打印公共部分 {


    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    static void printEqualNode(Node aNode, Node bNode) {
        Node a = aNode;
        Node b = bNode;

        while (a != null && b != null) {
            if (a.value == b.value) {
                System.out.print(a.value + " ");
                a = a.next;
                b = b.next;
            } else if (a.value < b.value) {
                a = a.next;
            } else {
                b = b.next;
            }
        }
    }

    public static void main(String[] args) {
        int preVal = Integer.MIN_VALUE;
        int val;

        Node aNode = new Node(preVal);
        Node aHead = aNode;
        for (int i = 0; i < 10; i++) {
            while ((val = IntValue.generateValue(i * 3)) < preVal) {
            }
            Node node = new Node(val);
            aHead.next = node;
            aHead = node;

            preVal = val;
            System.out.print(val + " ");
        }
        System.out.println();

        preVal = Integer.MIN_VALUE;
        Node bNode = new Node(preVal);
        Node bHead = bNode;
        for (int i = 0; i < 10; i++) {
            while ((val = IntValue.generateValue(i * 3)) < preVal) {
            }
            Node node = new Node(val);
            bHead.next = node;
            bHead = node;

            preVal = val;
            System.out.print(val + " ");
        }

        System.out.println();
        printEqualNode(aNode, bNode);
    }


}
