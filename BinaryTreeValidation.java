import java.util.LinkedList;
import java.util.Arrays;

//https://leetcode.com/problems/validate-binary-tree-nodes/
      
class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        
        // need to find potential root
        
        if(isEmptyTree(n, leftChild, rightChild)) return true;
        
        LinkedList<Integer> potentialRoots = 
            getPotentialRoots( n, leftChild, rightChild);
        
        for(Integer potentialRoot: potentialRoots) {
            if(validateTreeWithRoot( potentialRoot, n, leftChild, rightChild)) {
                return true;
            }
        }
            return false;
}

    private boolean isEmptyTree( int n, int[] leftChild, int[] rightChild) {
        if( n ==1 && leftChild[0] == -1 && rightChild[0] == -1) return true;
        return false;
    }
    private boolean validateTreeWithRoot(int root, int n, int[] leftChild, int[] rightChild) {
                
        // do a bfs visit of the entire tree, mark the traversed elements
        
        // if you visit all elements, then it is a bst. else fail
        
        // if you visit any element twice, there are two inbound endges. fail
        
        boolean[] visited = new boolean[n];
        
        Arrays.fill(visited, false);
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        // starting condition.
        visited[root] = true;
        queue.add(leftChild[root]);
        queue.add(rightChild[root]);
        
        while(!queue.isEmpty()) {
            
            // printQueue(queue);
            // dequeue the node, if it is a dead end, continue
            //check if the node is already visited.
            // if already visited, return false.
            // else, mark it as visited.
            // enquue the children
            
            int currentNode = queue.poll();
            
            if (currentNode == -1) continue;
            
            if(visited[currentNode]) {
                return false;
            } else {
                // node is not visited. Mark it as visited, and enquue its children
                visited[currentNode] = true;
                queue.add(leftChild[currentNode]);
                queue.add(rightChild[currentNode]);
            }
        }
            
            //Stream.of(visited)
            
        boolean allVisited = true;
            for(int i = 0; i < n ; i++) {
                allVisited = allVisited & visited[i];
            } 
            
            if(allVisited) {
                return true;
            } else {
                return false;
            }
            

    }
    
    private LinkedList<Integer> getPotentialRoots(int n, int[] leftChild, int[] rightChild) {
        
        LinkedList<Integer> potentialRoots = new LinkedList<Integer>();
        
        for(int i = 0; i< n; i++) {
            if(leftChild[i] >=0 && leftChild[i] <n) {
                potentialRoots.add(i);
                continue;
            }
            
            if(rightChild[i] >= 0 && rightChild[i] < n) {
                potentialRoots.add(i);
                
            }
        }
        
        return potentialRoots;
    }
    
    private void printQueue(LinkedList<Integer> ll) {
        for(Integer i: ll) {
            System.out.println(i);
        }
    }
}

