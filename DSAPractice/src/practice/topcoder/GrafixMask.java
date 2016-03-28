package practice.topcoder;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2998&rd=5857
 * 
 */
public class GrafixMask {
	private int[][] grid;
	private static final int width = 600;
	private static final int height = 400;
	
	public GrafixMask() {
		this.grid = new int[height][width];
	}
	
	public int[] sortedAreas(String[] rectangles) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		maskRectangles(rectangles);
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				if(grid[i][j] == 0) {
					result.add(dfs(i, j));
				}
			}
		}
		Collections.sort(result);
		int[] resultArr = new int[result.size()];
		int i = 0;
		for(int area: result) {
			resultArr[i++] = area;
		}
		return resultArr;
	}
	
	private void maskRectangles(String[] rectangles) {
		for(String rectangle: rectangles) {
			String[] dim = rectangle.split(" ");
			int x1 = Integer.parseInt(dim[0]);
			int y1 = Integer.parseInt(dim[1]);
			int maxY2 = Integer.parseInt(dim[3]);
			int maxX2 = Integer.parseInt(dim[2]);
			for(int i = x1; i <= maxX2; i++) {
				for(int j = y1; j <= maxY2; j++) {
					grid[i][j] = 1;
				}
			}
		}
	}
	
	private static class Coordinate {
		int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private int dfs(int i, int j) {
		Stack<Coordinate> dfsStack = new Stack<Coordinate>();
		grid[i][j] = -1;
		dfsStack.push(new Coordinate(i, j));
		int area = 0;
		while(!dfsStack.isEmpty()) {
			Coordinate c = dfsStack.pop();
			int x = c.x;
			int y = c.y;
			grid[x][y] = 1;
			area++;
			if((x+1) < height && grid[x+1][y] == 0) {
				dfsStack.push(new Coordinate(x+1, y));
				grid[x+1][y] = -1;
			}
			if((x-1) >= 0 && grid[x-1][y] == 0) {
				dfsStack.push(new Coordinate(x-1, y));
				grid[x-1][y] = -1;
			}
			if((y+1) < width && grid[x][y+1] == 0) {
				dfsStack.push(new Coordinate(x, y+1));
				grid[x][y+1] = -1;
			}
			if((y-1) >= 0 && grid[x][y-1] == 0) {
				dfsStack.push(new Coordinate(x, y-1));
				grid[x][y-1] = -1;
			}
		}
		return area;
	}
}
