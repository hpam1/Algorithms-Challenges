package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/no-prefix-set
 * 
 */
public class NoPrefixSet {
    private static class Trie {
        private Node root;
        
        private static class Node {
            private Node[] children;
            private int words;
            
            public Node() {
                this.children = new Node[10];
                this.words = 0;
            }
        }
        
        public Trie() {
            this.root = new Node();
        }
        
        public boolean addWord(String word) {
            Node node = root;
            for(int i = 0;i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new Node();
                } else {
                    if(node.children[index].words > 0)
                        return false;
                    if((i+1) == word.length())
                        return false;
                }
                node = node.children[index];
            }
            node.words++;
            return true;
        }
    }
    
    private Trie trie;
    
    public NoPrefixSet() {
        this.trie = new Trie();
    }
    
    public boolean add(String word) {
        return trie.addWord(word);
    }
    
    public static void main(String[] args) {
    	NoPrefixSet s = new NoPrefixSet();
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while(N > 0) {
            String str = in.nextLine();
            if(!s.add(str)) {
                System.out.println("BAD SET");
                System.out.println(str);
                return;
            }
            N--;
        }
        System.out.println("GOOD SET");
    }
}
