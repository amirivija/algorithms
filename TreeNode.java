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
   
   //https://leetcode.com/problems/path-sum/description/
   //Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf
   // path such that adding up all the values along the path equals targetSum. 
    public boolean hasPathSum(TreeNode root, int targetSum) {
      if(root == null) {
	// There is no path sum for an empty tree.
	return false;
      }


	if (root.left == null && root.right == null) {
		// leaf node
		if(root.val == targetSum) {
			return true;
		} else {
			return false;
		}
	}


	if(hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val)) {
		return true;
	} else {
		return false;
	}
   }

}
