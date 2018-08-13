package common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static void sout(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next == null ? "\n" : "->"));
            head = head.next;
        }
    }
}
