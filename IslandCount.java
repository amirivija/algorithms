import java.util.*;
// https://leetcode.com/problems/number-of-islands/
public class IslandCount {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        if(cols == 0) return 0;
        boolean visited[][] = new boolean[rows][cols];
        int numOfIslands = 0;
        for(int i = 0; i< rows; i++) {
            for(int j =0; j< cols; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    numOfIslands ++;
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.add(new Tuple(i, j));
        visited[i][j] = true;
        while(!queue.isEmpty()) {
            Tuple current = queue.remove();
            int row = current.row;
            int column = current.column;
            
            
            if(row - 1 >= 0 && grid[row - 1][column] == '1' && !visited[row - 1][column]) {
                queue.add(new Tuple(row - 1, column));
                visited[row - 1][column] = true;
            }

            if(row + 1 < rows && grid[row + 1][column] == '1' && !visited[row + 1][column]) {
                queue.add(new Tuple(row + 1, column));
                visited[row + 1][column] = true;
            }
            
            if(column - 1 >=0 && grid[row][column - 1] == '1' && !visited[row][column - 1]) {
                queue.add(new Tuple(row, column - 1));
                visited[row][column - 1] = true;
            }
            
            if(column + 1 < cols && grid[row][column + 1] == '1' && !visited[row][column + 1]) {
                queue.add(new Tuple(row, column + 1));
                visited[row][column + 1] = true;
            }
            
        }
                }
            }
        }
        
        return numOfIslands;
    }
    
    private class Tuple {
        public int row, column; 
        
        public Tuple(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
