package 程序员代码面试指南.链表问题;

import 程序员代码面试指南.common.Node;

public class 反转部分单向链表 {

    public Node reversePart (Node head, int from, int to) {
        if (to <= from) {
            return head;
        }

        Node cur = head;
        int i = 1;
        while (cur != null && ++i != from) {
            cur = cur.next;
        }
        Node fromPre = cur;


        return head;
    }
}
