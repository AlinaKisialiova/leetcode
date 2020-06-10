package easy;

import java.util.LinkedList;
import java.util.Queue;

/* #112
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
Note: A leaf is a node with no children.

Example:
Given the below binary tree and sum = 22,
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))
        );

        PathSum checker = new PathSum();
        boolean result = checker.hasPathSum(tree, 22);
        assert result : "Solution is wrong";
        result = checker.hasPathSum(tree, 10);
        assert !result : "Solution is wrong";
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //BST
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> sumForNode = new LinkedList<>();
        nodes.add(root);
        sumForNode.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode current = nodes.poll();
            int currentSum = sumForNode.poll();
            if (current.left == null && current.right == null && currentSum == sum) {
                return true;
            }
            if (current.left != null) {
                nodes.add(current.left);
                sumForNode.add(currentSum + current.left.val);
            }
            if (current.right != null) {
                nodes.add(current.right);
                sumForNode.add(currentSum + current.right.val);
            }
        }
        return false;
    }

    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && (root.left == null && root.right == null))
            return true;

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }

    // Definition for a binary tree node.
    public  static class TreeNode {
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
