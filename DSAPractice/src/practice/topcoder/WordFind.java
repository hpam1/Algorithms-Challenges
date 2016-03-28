package practice.topcoder;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=3972
 * 
 */
public class WordFind {
	private static class Trie {
		private static class Node {
			int i;
			int j;
			Node[] children;
			public Node() {
				i = -1;
				j = -1;
				children = new Node[26];
			}
			public Node(int i, int j) {
				this.i = i;
				this.j = j;
				children = new Node[26];
			}
		}
		private Node root;
		public Trie() {
			root = new Node();
		}
		public void addWord(String word, int p, int q) {
			Node node = root;
			for(int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'A';
				if(node.children[index] == null) {
					node.children[index] = new Node(p, q);
				}
				node = node.children[index];
			}
		}
		public String containsWord(String word) {
			StringBuilder sb = new StringBuilder("");
			Node node = root;
			for(int i = 0; i < word.length(); i++) {
				int index = word.charAt(i) - 'A';
				if(node.children[index] == null)
					return sb.toString();
				node = node.children[index];
			}
			sb.append(node.i + " " + node.j);
			return sb.toString();
		}
	}
	private Trie trie;
	public WordFind() {
		trie = new Trie();
	}
	public String[] findWords(String[] grid, String[] wordList) {
		int m = grid.length;
		int n = grid[0].length();
		constructTrie(grid, m, n);
		String[] result = new String[wordList.length];
		int i = 0;
		for(String word: wordList) {
			result[i++] = trie.containsWord(word);
		}
		return result;
	}
	
	private void constructTrie(String[] grid, int m, int n) {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				String wordH = grid[i].substring(j);
				StringBuilder sb = new StringBuilder();
				for(int k = i; k < m; k++)
					sb.append(grid[k].charAt(j));
				String wordV = sb.toString();
				sb = new StringBuilder();
				int p = i, q = j;
				while(p < m && q < n)
					sb.append(grid[p++].charAt(q++));
				String wordD = sb.toString();
				trie.addWord(wordH, i, j);
				trie.addWord(wordV, i, j);
				trie.addWord(wordD, i, j);
			}
		}
	}
}