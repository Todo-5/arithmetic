package basic.other;

import java.util.Stack;

/**
 * 判断链表是否为回文结构（正反念都一样，1-2-1）
 * 要求： 时间复杂度O(N)，空间复杂度O(1)
 *
 * 思路：
 * 1 -> 2 -> 3 -> 2 -> 1
 * - 使用两个指针，慢指针一次走一步，快指针一次走两步。
 * - 两个指针同时移动，当快指针走到 node.next == null 末尾时，慢指针正好走到链表的中点midNode！！！
 * - 将 midNode 的next指向为 null， midNode之后的链表指针逆序
 *   1 -> 2 -> (3, midNode.next = null) <- 2 <- 1
 * - 之后从链表首节点 和 末尾节点 endPoint 同时走 next进行比较，比较走到 3 处的 next = null 结束，
 *   如果都相等则是回文，出现一个不匹配就不是回文。
 * - 比较完成后需要将改动过的链表还原！！
 * 【midNode，在奇数个时直接位于中点，如果是偶数个时（1-2-2-1），位于中点的前一个即（1-2，2为中点）】
 *
 * 引言：
 * 如果不考虑额外空间复杂度，则可以将链表进行入栈，然后pop弹出的数据就是链表逆序的，通过和原始数据进行比较即可。
 * 如1-2-3，入栈1-2-3，出栈3-2-1，通过pop和原链表比较，pop(3) == 1，pop(2) == 2,pop(1) == 3
 *
 * @author: for-us.cc
 * @date: 2021/10/17
 */
public class 链表是否回文 {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 需要 额外空间 O(N)
     * @param head
     * @return
     */
    static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Node root = head;
        while(root != null) {
            stack.push(root.value);
            root = root.next;
        }

        root = head;
        while (!stack.empty()) {
            Integer pop = stack.pop();
            if (root.value != pop) {
                return false;
            }
            root = root.next;
        }
        return true;
    }


    /**
     * 需要额外空间 O(N/2)，方法和上面的 isPalindrome1 一样，只是先将链表遍历一般，将后半份链表压入 stack，
     * 因此只需要 一般的额外空间。
     *
     * 一个指针走一步，一个指针走两步，当两步指针的 next为null时，表示 一步指针在中点位置
     *
     * @param head
     * @return
     */
    static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        /**
         *  遍历链表用于记录中间位置.
         *  首先 oneStep = head.next; 是为了在奇数个时入栈 n/2 - 1元素，偶数个时入栈 n/2 元素
         */
        Node oneStep = head.next;
        Node twoStep = head;
        while (twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (oneStep != null) {
            stack.push(oneStep.value);
            oneStep = oneStep.next;
        }

        Node root = head;
        while(!stack.empty()) {
            if (root.value != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 额外空间O(1)
     *
     * 就是将原链表中的一半进行逆序，左链表从 head 向后，右链表从tail向前比较。
     *
     * @param head
     * @return
     */
    static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        /* 走到中点位置oneStep，奇数个时为中位，偶数个时为两者之左 */
        Node oStep = head;
        Node tStep = head;
        while (tStep.next != null && tStep.next.next != null) {
            oStep = oStep.next;
            tStep = tStep.next.next;
        }
        /* 右半链表的左边第一个节点元素 */
        Node rNode = oStep.next;
        /* 设置中节点的 next为 null */
        oStep.next = null;
        /* 将右半链表反转，此时 oStep处于中点处， */
        Node temp;
        while (rNode != null) {
            temp = rNode.next;
            rNode.next = oStep;
            oStep = rNode;
            rNode = temp;
        }

        /* 右边最后一个节点和左边第一个节点开始依次比较值相等 */
        Node rHead = oStep;
        Node lHead = head;
        boolean isPalindrome = true;
        while (rHead != null && lHead != null) {
            if (rHead.value != lHead.value) {
                isPalindrome = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        /* 将逆序的链表还原成原始结构 */
        /* oStep 是原链表最后一个节点元素，也是右半链表的头节点 */
        Node rTail = oStep.next;
        oStep.next = null;
        while (rTail != null) {
            temp = rTail.next;
            rTail.next = oStep;
            oStep = rTail;
            rTail = temp;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        Node node4 = new Node(4);

        Node node5 = new Node(3);
        Node node6 = new Node(2);
        Node node7 = new Node(1);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        /* 方法一 */
        System.out.println("n：" + isPalindrome1(head));
        for (Node root = head; root != null; root = root.next) {
            System.out.print(root.value + "-");
        }
        System.out.println();
        System.out.println();

        /* 方法二  */
        System.out.println("n/2：" + isPalindrome1(head));
        for (Node root = head; root != null; root = root.next) {
            System.out.print(root.value + "-");
        }
        System.out.println();
        System.out.println();

        /* 方法三 */
        System.out.println("1：" + isPalindrome3(head));
        for (Node root = head; root != null; root = root.next) {
            System.out.print(root.value + "-");
        }

    }
}
