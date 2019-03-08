package 程序员代码面试指南.二叉树;

import java.util.Stack;

public class 二叉树的前中后序遍历递归非递归 {
    public void preOrder (Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "  ");

        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder2 (Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            System.out.print(p.val + " ");
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
    }

    public void inOrder (Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + "  ");
        inOrder(root.right);
    }

    public void inOrder2 (Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().left != null) {
                stack.push(stack.peek().left);
            }

            Node p = stack.pop();
            System.out.print(p.val + "  ");
            if (p.right != null) {
                stack.push(p.right);
            }
        }
    }


    public void postOrder (Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + "  ");
    }

    /**
     * 对于任一结点P，先将其入栈。如果P不存在左孩子和右孩子，则可以直接访问它；
     * 或者P存 在左孩子或者右孩子，但是其左孩子和右孩子都已被访问过了，则同样可以直接访问该结点。
     * 若非上述两种情况，则将P的右孩子和左孩子依次入栈，这样就保证了 每次取栈顶元素的时候，
     * 左孩子在右孩子前面被访问，左孩子和右孩子都在根结点前面被访问。
     *
     * @param root
     */
    public void postOrder2 (Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node pre = null;
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if ((node.left == null || node.right == null)
                    || (pre != null && (pre == node.left || pre == node.right))) {
                Node p = stack.pop();
                System.out.print(p.val + "  ");
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
    }
}
