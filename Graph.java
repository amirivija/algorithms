import java.util.*;

class Graph {
 boolean[] seen;

/* 
 * https://leetcode.com/problems/number-of-provinces/
 *
 * Function to find the number of connected components in a graph.
 * First Construct the graph as an adjacency list.
 * Have a array of boolean seen - to identify if the graph has been visited.
 * if the graph node is not visited, mark it as visited and visit it in dfs way (marking all components as seen along the way).
 * At each start of a dfs from an unvisited node, increment the count and start a dfs from the unvisited node
 */
  public int findNumberOfConnectedProvinces(int[][] isConnected) {
  seen = new boolean[isConnected.length];
  Map<Integer, List<Integer>> graph = buildGraph(isConnected);
 int numProvinces = 0;
 for ( int i = 0; i < isConnected.length; i++ ) {
   if(!seen[i]) {
     numProvinces ++;
     seen[i] = true;
     dfs(i, graph);
   }
  
 }


 return numProvinces;     
  }




 private void dfs(int node, Map<Integer, List<Integer>> graph ) {
   for( int currentNode: graph.get(node)) {
     if(!seen[currentNode]) {
     seen[currentNode] = true;
     dfs(currentNode, graph);
     }
   }
 }




 private Map<Integer, List<Integer>> buildGraph(int[][] isConnected) {
 Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
 // Build a Graph - adjacency list
 for(int i = 0; i < isConnected.length; i++) {
   if(!graph.containsKey(i)) {
     // create the node in the map
     graph.put(i, new ArrayList<Integer>());
   }




   for ( int j = i; j < isConnected.length; j++) {
   if(!graph.containsKey(j)) {
     // create the node in the map
     graph.put(j, new ArrayList<Integer>());
   }
     if(isConnected[i][j] == 1) {
       graph.get(i).add(j);
       graph.get(j).add(i);
     }
     }
   }
   return graph;
   }
}

