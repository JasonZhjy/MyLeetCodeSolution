package rcAlgorithm;

public class TreeAlg {
    class Node {
        Node left;
        Node right;
        int floor;
    }

    /**
     * 在二进制树中的节点之间的最大距离（最长路径树）——递归解决方案
     * 题目就是求一棵树中的最长路径
     * 对于节点t，以它为根的树的最长路径path一定是下列三个数中的最大值：
     * ①t的左子树的最长路径lpath
     * ②t的右子树的最长路径rpath
     * ③t的左子树的高度+t的右子树的高度
     *
     * @param tree
     * @return
     */
    public int findMaxPath (Node root) {
        if (null != root) {
            int lPath = findMaxPath(root.left);
            int rPath = findMaxPath(root.right);

            int lHeight = root.left != null ? root.left.floor : 0;
            int rHeight = root.right != null ? root.right.floor : 0;
            root.floor = Math.max(lHeight, rHeight) + 1;
            return Math.max(Math.max(lPath, rPath), root.floor);
        } else {
            return 0;
        }
    }
}
