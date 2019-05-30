package algorithm;

import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;

/**
 * LeetCode 173.
 */
public class BSTIterator {

    private LinkedList<TreeNode> stack = new LinkedList<>();
    public BSTIterator (TreeNode root) {

    }

    /** @return the next smallest number */
    public int next() {

        return 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {

        return !stack.isEmpty();
    }

    private void pushLeft (TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
//            cur = cur.left;
        }
    }

    public static void main (String[] args) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
//        linkedList.push();
    }
}
