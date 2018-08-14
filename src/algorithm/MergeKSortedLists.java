package algorithm;

import common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    //使用归并排序
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            ListNode left = mergeSort(lists, 0, mid);
            ListNode right = mergeSort(lists, mid + 1, end);
            return merge(left, right);
        }

        return lists[beg];
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(0), tail = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if (left != null) tail.next = left;
        if (right != null) tail.next = right;

        return head.next;
    }

    /******************* Solution 2. 使用小顶堆*****important**********************************/
    public ListNode mergeKLists_solution2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.add(lists[i]);
            }
        }
        ListNode head = null, tail = null;
        while(!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;

            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode[] arr = new ListNode[3];
        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(4);
        arr[0].next.next = new ListNode(5);

        arr[1] = new ListNode(1);
        arr[1].next = new ListNode(3);
        arr[1].next.next = new ListNode(4);
        arr[2] = new ListNode(2);
        arr[2].next = new ListNode(6);

        MergeKSortedLists test = new MergeKSortedLists();
        ListNode rs = test.mergeKLists(arr);

        ListNode.sout(rs);

    }
}
