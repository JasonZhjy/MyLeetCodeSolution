package mytest;

public class DFS {
    private Node root;

    void init() {
        root = new Node();
    }

}

class Node {
    int val;
    Node left;
    Node right;

    public Node() { }

    public Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
