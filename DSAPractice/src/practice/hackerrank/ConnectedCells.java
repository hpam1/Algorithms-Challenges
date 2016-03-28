package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/connected-cell-in-a-grid
 * 
 */
public class ConnectedCells {
    static int getLargestRegion(int[][] grid, int m, int n) {
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    int maxDepth = DFS(grid, i, j, m, n);
                    if(max < maxDepth)
                        max = maxDepth;
                }
            }
        }
        return max;
    }
    
    static int DFS(int[][] grid, int i, int j, int m, int n) {
        Stack<String> dfsStack = new Stack<String>();
        String cell = "" + i + j;
        dfsStack.push(cell);
        int depth = 0;
        while(!dfsStack.isEmpty()) {
            String cellid = dfsStack.pop();
            int row = cellid.charAt(0) - 48;
            int col = cellid.charAt(1) - 48;
            if(grid[row][col] == 1) {
                depth++;
                grid[row][col] = 2;
                if(col -1 >= 0 && grid[row][col-1] == 1) {
                    cell = "" + row + (col - 1);
                    dfsStack.push(cell);
                }
                if(col + 1 < n && grid[row][col+1] == 1) {
                    cell = "" + row + (col + 1);
                    dfsStack.push(cell);
                }
                if(row -1 >= 0 && grid[row -1][col] == 1) {
                    cell = "" + (row -1) + col;
                    dfsStack.push(cell);
                }
                if(row + 1 < m && grid[row + 1][col] == 1) {
                    cell = "" + (row + 1) + col;
                    dfsStack.push(cell);
                }
                if(row + 1 < m && col + 1 < n && grid[row + 1][col + 1] == 1) {
                    cell = "" + (row + 1) + (col + 1);
                    dfsStack.push(cell);
                }
                if(row - 1 >= 0 && col -1 >= 0 && grid[row -1][col - 1] == 1) {
                    cell = "" + (row -1) + (col - 1);
                    dfsStack.push(cell);
                }
                if(row -1 >= 0 && col +1 < n && grid[row -1][col+1] == 1) {
                    cell = "" + (row -1) + (col + 1);
                    dfsStack.push(cell);
                }
                if(row + 1 < m && col - 1 >= 0 && grid[row+1][col-1] == 1) {
                    cell = "" + (row + 1) + (col -1);
                    dfsStack.push(cell);
                }
            }
        }
        return depth;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            String[] row = in.nextLine().split(" ");
            for(int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(row[j]);
            }
        }
        System.out.println(getLargestRegion(grid, m, n));
    }
}