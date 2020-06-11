package medium;

import java.util.Stack;

/* #98
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:
    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:
    5
   / \
  1   4
     / \
    3   6

Input: [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode validTree = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        ValidateBinarySearchTree validator = new ValidateBinarySearchTree();
        boolean validResult = validator.isValidBST(validTree);
        assert validResult : "Solution is wrong";
        TreeNode invalidTree = new TreeNode(5, new TreeNode(1, null, null), new TreeNode(4, new TreeNode(3, null, null), new TreeNode(6, null, null)));
        boolean invalidResult = validator.isValidBST(invalidTree);
        assert !invalidResult : "Solution is wrong";
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root);
    }

    // Pre-order traversal: Left -> Node -> Right
    // In pre-order traversal for BST each element should be smaller than the next one.
    private boolean validate(TreeNode root) {
        Stack<TreeNode> way = new Stack<>();
        Integer previousNodeValue = null;
        while (!way.isEmpty() || root != null) {
            while (root != null) {
                way.push(root);
                root = root.left;
            }
            root = way.pop();
            if (previousNodeValue != null && previousNodeValue >= root.val) {
                return false;
            }
            previousNodeValue = root.val;
            root = root.right;
        }
        return true;
    }

    private boolean validateRecursion(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int nodeValue = root.val;
        if (lower != null && nodeValue <= lower) {
            return false;
        }
        if (upper != null && nodeValue >= upper) {
            return false;
        }
        if (!validateRecursion(root.left, lower, nodeValue)) {
            return false;
        }
        if (!validateRecursion(root.right, nodeValue, upper)) {
            return false;
        }
        return true;
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
