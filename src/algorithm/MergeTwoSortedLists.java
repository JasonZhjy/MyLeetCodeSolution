package algorithm;

import common.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null, p = l1, q = l2, e = null;
        while (p != null && q != null) {
            if (p.val < q.val) {
                e = p;
                p = p.next;
            } else {
                e = q;
                q = q.next;
            }

            if (tail == null)
                head = e;
            else
                tail.next = e;
            tail = e;
        }

        ListNode k = p != null ? p : q;

        if (tail == null)
            head = k;
        else
            tail.next = k;

        return head;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        ListNode head1 = null, head2 = null;
        head1 = new ListNode(1);
        ListNode last = head1;
        ListNode q = new ListNode(2);
        last.next = q;
        last = q;
        q = new ListNode(4);
        last.next = q;

        head2 = new ListNode(3);
        ListNode last2 = head2;
        q = new ListNode(5);
        last2.next = q;

        ListNode.sout(head1);
        ListNode.sout(head2);
        System.out.println("result:");
        ListNode.sout(test.mergeTwoLists(head1, head2));

    }

}
