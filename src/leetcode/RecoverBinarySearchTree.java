/*
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * 
	 * Recover the tree without changing its structure.
	 * 
	 * Note: A solution using O(n) space is pretty straight forward. Could you
	 * devise a constant space solution?
	 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecoverBinarySearchTree {
	public static void recoverTree(TreeNode root) {
		List<TreeNode> store = new ArrayList<TreeNode>();
		recoverTree(root, store);
		int[] remis = new int[store.size()];
		for (int i = 0; i < store.size(); i++) {
			remis[i] = store.get(i).val;
		}
		Arrays.sort(remis);
		for (int i = 0; i < store.size(); i++) {
			store.get(i).val = remis[i];
		}
	}

	public static void recoverTree(TreeNode root, List<TreeNode> store) {
		if (root == null) {
			return;
		} else {
			recoverTree(root.left, store);
			store.add(root);
			recoverTree(root.right, store);
		}
	}
}
