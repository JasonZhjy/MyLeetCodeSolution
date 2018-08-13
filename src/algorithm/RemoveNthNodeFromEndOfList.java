package algorithm;

import common.ListNode;

public class RemoveNthNodeFromEndOfList {
    // Given n will always be valid.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode targetBefore = head;
        // 1. Get after n node.
        ListNode nodeAfterN = getNodeAfterN(targetBefore, n);
        // n == size.
        if (nodeAfterN == null) {
            return head.next;
        }
        while (nodeAfterN.next != null) {
            targetBefore = targetBefore.next;
            nodeAfterN = nodeAfterN.next;
        }

        // 2. Remove node.
        targetBefore.next = targetBefore.next.next;

        return head;
    }

    private ListNode getNodeAfterN(ListNode node, int n) {
        ListNode p = node;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        return p;
    }


    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();

        ListNode head = test.init();
        sout(head);

        ListNode rs = test.removeNthFromEnd(head, 1);
        sout(rs);
    }

    ListNode init() {
        ListNode head = new ListNode(1);
//        ListNode last = head;
//        ListNode q = new ListNode(2);
//        last.next = q;
//        last = q;
//        q = new ListNode(3);
//        last.next = q;
//        last = q;
//        q = new ListNode(4);
//        last.next = q;
//        last = q;
//        q = new ListNode(5);
//        last.next = q;

        return head;
    }

    static void sout(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next == null ? "\n" : "->"));
            head = head.next;
        }
    }

}


