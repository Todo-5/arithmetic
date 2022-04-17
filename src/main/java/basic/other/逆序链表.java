package basic.other;

import lombok.Data;

/**
 * 逆序链表结构
 *
 * @author: for-us.cc
 * @date: 2021/11/01
 */
public class 逆序链表 {


    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 翻转列表
     * @param head
     * @return
     */
    static Node reverse(Node head) {
        Node pre = null;
        Node next;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node point = head;
        Node node;
        for (int i = 0; i < 10; i++) {
            node = new Node(i * i);
            point.next = node;
            point = node;
        }

        Node root = head;
        while (root != null) {
            System.out.printf(root.value + " ");
            root = root.next;
        }
        System.out.println();

        Node reverse = reverse(head);
        while (reverse != null) {
            System.out.printf(reverse.value + " ");
            reverse = reverse.next;
        }
    }
}
