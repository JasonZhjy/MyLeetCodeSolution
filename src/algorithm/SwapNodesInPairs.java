package algorithm;

import common.ListNode;

/*
24. Swap Nodes in Pairs
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head, pre = h;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = next;

            pre = cur;
            cur = next;
        }

        return h.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs test = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode rs = test.swapPairs(head);

        ListNode.sout(rs);
    }
}
