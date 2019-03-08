package 程序员代码面试指南.链表问题;

public class 打印两个有序链表的公共部分 {

    public void printCommonPart (Node head1, Node head2) {
        System.out.println("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.print(head1.val + " -> ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    public class Node {
        public int val;
        public Node next;

        public Node (int val) {
            this.val = val;
        }
    }
}
