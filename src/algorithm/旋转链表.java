package algorithm;

import common.ListNode;

/**
 * 61. 旋转链表
 */
public class 旋转链表 {

    public ListNode rotateRight (ListNode head, int k) {
        if (head == null) return head;
        ListNode beg = head, end = null, lastK_1 = head;
        int len = 0;
        while (beg != null) {
            end = beg;
            beg = beg.next;
            len++;
        }
        int j = k % len;
        if (j == 0) {
            return head;
        }

        // get next k node.
        for (int i = 0; i < len - j - 1; i++) {
            lastK_1 = lastK_1.next;
        }

        beg = lastK_1.next;
        end.next = head;
        lastK_1.next = null;

        return beg;
    }


    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        旋转链表 test = new 旋转链表();
        ListNode node = test.rotateRight(head, 2);

        ListNode.sout(node);
    }
}
