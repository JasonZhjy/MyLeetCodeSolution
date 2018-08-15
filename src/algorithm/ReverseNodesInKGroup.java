package algorithm;

import common.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h, cur = head, end;
        while(cur != null && (end = getNextK(cur, k - 1)) != null) {
            reverseListNode(pre, cur, end);
            pre = cur;
            cur = cur.next;
        }

        return h.next;
    }

    private void reverseListNode(ListNode pre, ListNode head, ListNode end) {
        ListNode cur = head, next, lastEnd = end.next;
        pre.next = end;
        while(cur != lastEnd) {
            next = cur.next;
            cur.next = cur == head ? lastEnd : pre;
            pre = cur;
            cur = next;
        }
    }

    private ListNode getNextK(ListNode head, int k) {
        ListNode h = head;
        for (int i = 0; i < k && h != null; i++) {
            h = h.next;
        }

        return h;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup test = new ReverseNodesInKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode rs = test.reverseKGroup(head, 3);
        ListNode.sout(rs);
    }
}
