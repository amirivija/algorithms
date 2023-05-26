import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

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

   // https://leetcode.com/problems/count-good-nodes-in-binary-tree/
   // Given a binary tree root, a node X in the tree is named good if in the path from root to X 
   // there are no nodes with a value greater than X.
	public int goodNodes(TreeNode root) {
		return getNumberOfGoodNodes(root, root.val, 1);
    	}

	private int getNumberOfGoodNodes(TreeNode root, int currentMax, int currentGoodNodes) {
		if (root == null) {
			return 0;
		}
	int isCurrentNodeGood = 0;
	
	if(root.val >= currentMax) {
		currentMax = root.val;
		currentGoodNodes++;
		isCurrentNodeGood = 1;
	}

	int leftGoodNodes = getNumberOfGoodNodes(root.left, currentMax, currentGoodNodes);
	int rightGoodNodes = getNumberOfGoodNodes(root.right, currentMax, currentGoodNodes);
	return leftGoodNodes + rightGoodNodes + isCurrentNodeGood;
	
	}

// https://leetcode.com/problems/binary-tree-right-side-view/description/
// If you are standing to the right of the binary tree, get the values that you will see at each level.
// This will be the rightmost node in each level.
// Use a BFS, at each level iteration, the Deque will have all the nodes in the level. Get the rightmost node from that level
//
   public List<Integer> rightSideView(TreeNode root) {
 if(root == null) {
   return Collections.emptyList();
 }


 List<Integer> rightMostValues = new ArrayList<Integer>();

// Queue for BFS Traversal
 Deque<TreeNode> bfsTraversal = new LinkedList<TreeNode>();

//Initializing the traversal by adding the root
 bfsTraversal.add(root);

// traversing through levels until no more nodes are present
 while(!bfsTraversal.isEmpty()) {
  
   int levelLength = bfsTraversal.size();
   // get the rightmost value. peek, but dont remove.
   rightMostValues.add(bfsTraversal.peekLast().val);
   for( int i = 0; i < levelLength; i++) {
     TreeNode node = bfsTraversal.remove();
    
     if( node.left != null) {
       bfsTraversal.add(node.left);
       }

     if( node.right != null) {
        bfsTraversal.add(node.right);
        }
     }
   }




 return rightMostValues;


}

//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
//Traverse each level in a BFS. Get the max value while traversing each level and store it in an array
public List<Integer> largestValues(TreeNode root) {
   if(root == null) {
   return Collections.emptyList();
 }


// Queue to traverse
 Deque<TreeNode> bfsTraversal = new LinkedList<TreeNode> ();


// List to store the max elements in each level
 List<Integer> maxElements = new ArrayList<Integer>();


 bfsTraversal.add(root);


 while(!bfsTraversal.isEmpty()) {


   int levelLength = bfsTraversal.size();
   int levelMax  = Integer.MIN_VALUE;
   for(int i = 0; i < levelLength; i++ ) {
     TreeNode node = bfsTraversal.remove();
	// get the max in each level.
     if(node.val > levelMax) {
       levelMax = node.val;
     }


     if(node.left != null) {
       bfsTraversal.add(node.left);
     }
     if(node.right != null) {
       bfsTraversal.add(node.right);
     }
   }
 maxElements.add(levelMax);


 }
 return maxElements;


}
}
