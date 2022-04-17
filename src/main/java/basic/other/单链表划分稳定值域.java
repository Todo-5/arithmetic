package basic.other;

/**
 * 单链表按照某个值 num，以稳定的方式划出 小于num、等于num、大于num的三个区域。
 *
 * hit：
 * - 使用三个区域 less、 equ、 more，每个区域都有head指针和tail指针，初始head==tail==null。
 * - 遍历链表，将每个节点的值划入制定的区域内，并挂在对应区域的 tail 指针下，达到稳定性。
 * - 最后将各个区域的节点连接在一起即可（需要判断边界，可能存在某个区域没有节点）
 *
 * @author: for-us.cc
 * @date: 2021/11/01
 */
public class 单链表划分稳定值域 {

    static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 开辟一个额外的数组空间N 来存储节点，然后在数组中将 pviot 进行划分，最终将数组中有序的方式 link 在一起。
     * @param node
     * @param pivot
     * @return
     */
    static Node arrayPartition(Node node, int pivot) {
        if (node == null) {
            return node;
        }

        /* 计算节点数，开辟数组空间存储节点 */
        Node current = node;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        Node[] array = new Node[count];
        current = node;
        for (int i = 0; i < count; i++) {
            array[i] = current;
            current = current.next;
        }
        
        /* 对数组中的元素进行划分 */
        partition(array, pivot);
        
        /* 将划分好的数组节点连接在一起 */
        count = count - 1;
        for (int i = 0; i < count; i++) {
            array[i].next = array[i + 1];
        }
        array[count].next = null;

        /* 将头节点 head 暴露出去 */
        return array[0];
    }

    /**
     * 按照快排的 大小等于 方式进行划分
     * @param array
     * @param pivot
     */
    private static void partition(Node[] array, int pivot) {
        int start = -1;
        int end = array.length;
        int index = 0;
        while (index < end) {
            if (array[index].value == pivot) {
                index++;
            } else if (array[index].value < pivot) {
                swap(array, ++start, index++);
            } else {
                swap(array, --end, index);
            }
        }
    }

    /**
     * =================================================
     * 第二种方式处理：使用 三个区域，六个指针来处理划分问题
     * =================================================
     */
    public static Node listPartition(Node head, int pivot) {
        return null;
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);


        head1 = arrayPartition(head1, 5);
        printLinkedList(head1);
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    private static void swap(Node[] array, int i, int j) {
        Node stat = array[i];
        array[i] = array[j];
        array[j] = stat;
    }
}
