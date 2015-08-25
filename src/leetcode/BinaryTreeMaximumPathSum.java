/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * */
package leetcode;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxPath(root);
		return max;
	}

	public int maxPath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int L = maxPath(root.left);
		int R = maxPath(root.right);
		max = Math.max(max, L + R + root.val);
		if (L + R + root.val < 0) {
			return 0;
		} else {
			return Math.max(L, R) + root.val;
		}
	}
}
