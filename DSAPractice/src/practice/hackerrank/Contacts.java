package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/contacts
 * 
 */
public class Contacts {
    private static class Trie {
        private Node root;
        
        private static class Node {
            private Node[] children;
            private int prefix;
            
            public Node() {
                this.children = new Node[26];
                this.prefix = 0;
            }
        }
        
        public Trie() {
            this.root = new Node();
        }
        
        public void addWord(String name) {
            Node node = root;
            for(int i = 0;i < name.length(); i++) {
                int index = name.charAt(i) - 'a';
                if(node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node.children[index].prefix++;
                node = node.children[index];
            }
        }
        
        public int countPrefix(String prefix) {
            Node node = root;
            for(int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if(node.children[index] == null)
                    return 0;
                node = node.children[index];
            }
            return node.prefix;
        }
    }
    
    private Trie contactTrie;
    
    public Contacts() {
        contactTrie = new Trie();
    }
    
    public void add(String name) {
        contactTrie.addWord(name);
    }
    
    public int find(String prefix) {
        return contactTrie.countPrefix(prefix);
    }
    
    public static void main(String[] args) {
    	Contacts s = new Contacts();
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        for(int i = 0; i < N; i++) {
            String[] op = in.nextLine().split(" ");
            if(op[0].equals("add"))
                s.add(op[1]);
            else
                System.out.println(s.find(op[1]));
        }
    }
}