class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

public class BSTtoLL {

    Node first = null;
    Node last = null;

    public void helper(Node node) {
        if (node != null) {
            helper(node.left);
            if (last != null) {
                last.right = node;
                node.left = last;
            } else {
                first = node;
            }
            last = node;
            helper(node.right);
        }

    }

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }

    public static void main(String[] args) {
        BSTtoLL bst = new BSTtoLL();

    }

}
