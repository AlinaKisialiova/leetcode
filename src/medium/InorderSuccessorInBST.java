package medium;

/* #285
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

In Binary Tree, Inorder successor of a node is the next node in Inorder traversal of the Binary Tree.
Inorder Successor is NULL for the last node in Inorder traversal.
In BST, Inorder Successor is the node with the smallest key greater than the key of the input node.

     20
    / \
   8   22
  / \
 4   12
     / \
    10  14

For 8 successor is 10.
For 10 is 12.
For 14 is 20.
For 22 successor doesn't exist.
 */
public class InorderSuccessorInBST {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20, new TreeNode(8, new TreeNode(4), new TreeNode(12, new TreeNode(10), new TreeNode(14))), new TreeNode(22, new TreeNode(22), null));
        InorderSuccessorInBST successorFinder = new InorderSuccessorInBST();
        TreeNode successor10 = successorFinder.inorderSuccessor(tree, new TreeNode(8));
        assert successor10.val == 10 : "Solution is wrong";
        TreeNode successor20 = successorFinder.inorderSuccessor(tree, new TreeNode(14));
        assert successor20.val == 20 : "Solution is wrong";
        TreeNode noSuccessor = successorFinder.inorderSuccessor(tree, new TreeNode(22));
        assert  noSuccessor == null : "Solution is wrong";
    }

    // Time Complexity: O(h), where h is the height of the tree.
    // Auxiliary Space: O(1).
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        // If the right subtree exists, the successor of p is the minimum number of this right subtree.
        if (p.right != null) {
            return findTheMostLeft(p.right);
        }

        // Otherwise,
        // if p < root -> go traverse the left subtree
        // if p >= root -> go traverse the right subtree
        TreeNode successor = null;
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val) {
                //set successor only for left because the smallest nodes is in left subtree
                successor = current;
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return successor;
    }

    // Find the smallest node
    private TreeNode findTheMostLeft(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
