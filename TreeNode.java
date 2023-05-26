public class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
	}

	// https://leetcode.com/problems/maximum-depth-of-binary-tree/
	// Given the root of a binary tree, return its maximum depth.
	// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    public int maxDepth(TreeNode root) {
       	if (root == null) {
		return 0;
	}

	int leftDepth = maxDepth(root.left);
	int rightDepth = maxDepth(root.right);

	int max = leftDepth > rightDepth ? leftDepth : rightDepth;
	return max + 1;

    }
}
