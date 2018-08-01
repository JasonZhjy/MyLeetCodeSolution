package algorithm;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1), p = l1, k = l2;
        ListNode end = result;
        int up10 = 0;

        while (true) {
            if (p != null || k != null) {
                int r1 = p != null ? p.val : 0;
                int r2 = k != null ? k.val : 0;
                int sum = r1 + r2 + up10;
                up10 = sum / 10;
                ListNode node = new ListNode(sum % 10);
                end.next = node;
                end = node;
            } else {
                end.next = up10 > 0 ? new ListNode(up10) : null;
                break;
            }
            p = p != null ? p.next : null;
            k = k != null ? k.next : null;
        }

        return result.next;
    }


    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);

        ListNode l2 = new ListNode(0);

        ListNode result = test.addTwoNumbers(l1, l2);
        ListNode p = result;
        while (p != null) {
            System.out.print(p.val + "\t");
            p = p.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
