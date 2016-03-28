package practice.topcoder;

import java.util.Stack;

/**
 * https://community.topcoder.com/tc?module=ProblemDetail&rd=4472&pm=1524
 * 
 */
public class Marketing {
	private static final int UNINITIALIZED = 0;
	private static final int PROCESSING = -1;
	private static final int TEENAGERS = 1;
	private static final int ADULTS = 2;
	private int[][] grid;
	private int[] vertices;
	
	public void initializeGrid(int k, String[] compete) {
		this.grid = new int[k][k];
		int i  = 0;
		for(String str: compete) {
			String[] edges = str.split(" ");
			if(edges.length >= 1) {
				for(String edge: edges) {
					if(edge.length() > 0) {
						int j = Integer.parseInt(edge);
						grid[i][j] = 1;
						grid[j][i] = 1;
					}
				}
			}
			i++;
		}
		vertices = new int[k];
	}
	
	public long howMany(String[] compete) {
		int k = compete.length;
		initializeGrid(k, compete);
		long count = 1;
		for(int i = 0; i < k; i++) {
			if(vertices[i] == UNINITIALIZED) {
				count = count * dfs(i);
				if(count < 0)
					return -1;
			}
		}
		return count;
	}
	
	private long dfs(int u) {
		Stack<Integer> vertexStack = new Stack<Integer>();
		vertexStack.push(u);
		vertices[u] = TEENAGERS;
		int k = grid.length;
		while(!vertexStack.isEmpty()) {
			int vertex = vertexStack.pop();
			for(int j = 0; j < k; j++) {
				if(grid[vertex][j] == 1) {
					if(vertices[j] == UNINITIALIZED) {
						vertexStack.push(j);
						vertices[j] = (vertices[vertex] == TEENAGERS) ? ADULTS : TEENAGERS;
					} else {
						int diff = Math.abs(vertices[j] - vertices[vertex]);
						if(diff == 0)
							return -1;
					}
				}
			}
		}
		return 2;
	}
}