package 程序员代码面试指南.链表问题;

import 程序员代码面试指南.common.Node;

public class 链表是否为回文 {
    public boolean isPalindrome (Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node n1 = head, n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;       //n1 -> 中部
            n2 = n2.next.next;  //n2 -> 尾部
        }

        n2 = n1.next;   //n2 -> the right 第一个节点
        n1.next = null;
        Node n3;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }

        n3 = n1;    // the right 最后一个节点
        n2 = head;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        //...

        return res;
    }
}
