package 程序员代码面试指南.链表问题;

import 程序员代码面试指南.common.Node;

public class 删除链表中间节点 {

    /**
     * len->min
     * 1->1
     * 2->1
     * 3->2
     * 4->2
     * 5->3
     * 6->3
     * 可见 链表长度每增加2，中间节点向右移动1
     *
     * @param head
     * @return
     */
    public Node removeMinNode (Node head) {
        if (head == null || head.next == null) {
            return null;
        } else if (head.next.next == null) {
            return head.next;
        }
        Node cur = head, last = head, pre = null;
        while (last.next != null && last.next.next != null) {
            last = last.next.next;
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;

        return head;
    }

    /**
     * remove 第a/b个node
     *
     * @param head
     * @param a
     * @param b
     * @return
     */
    public Node removeByRadio (Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        n = (int) Math.ceil(((double) (n * a)) / b);
        if (n == 1) {
            return head.next;
        }
        cur = head;
        while (--n != 1) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }

}
