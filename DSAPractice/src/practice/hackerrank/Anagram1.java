package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams
 * 
 *
 */
public class Anagram1 {
    private int anagramCount;
    private static final int d = 26;
    private static final int q = 13;
    
    public Anagram1() {
        this.anagramCount = 0;
    }
    
    private int computeHash(String str) {
        int h = 0;
        for(int i = 0; i < str.length(); i++) {
        	h += (str.charAt(i) - 97);
        }
        return h;
    }
    
    private boolean compare(String s1, String s2) {
    	Map<Integer, Integer> charMap = new HashMap<Integer, Integer>();
    	for(int i = 0; i < s1.length(); i++) {
    		int index = s1.charAt(i) - 97;
    		if(charMap.containsKey(index)) {
    			int count = charMap.get(index) + 1;
    			charMap.put(index, count);
    		} else {
    			charMap.put(index, 1);
    		}
    	}
    	for(int i = 0; i < s2.length(); i++) {
    		int index = s2.charAt(i) - 97;
    		if(charMap.containsKey(index)) {
    			int count = charMap.get(index) - 1;
    			charMap.put(index,  count);
    		} else
    			return false;
    	}
    	for(int key: charMap.keySet()) {
    		if(charMap.get(key) != 0)
    			return false;
    	}
    	return true;
    }
       
    private void rabinKarpMatcher(String text, String pattern, int j) {
        int n = text.length();
        int m = pattern.length();
        int h = computeHash(pattern);
        int hs = computeHash(text.substring(0, m));
        int s = 0;
        int count = 0;
        
        while(s <= (n-m)) {
            if(h == hs && s > j) {
                if(compare(pattern, text.substring(s, s+m)))
                	count++;
            }
            s++;
            if(s <= (n-m))
            	hs = computeHash(text.substring(s, s+m)); 
                
        }
        anagramCount += count;
    }
    
    public int getAnagramCount(String str) {
        for(int i = 1; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(j <= (str.length() - i)) {
                    String pattern = str.substring(j, (j+i));
                    rabinKarpMatcher(str, pattern, j);
                }
            }
        }
        return anagramCount;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while(N > 0) {
            String text = in.nextLine();
            Anagram1 sol = new Anagram1();
            System.out.println(sol.getAnagramCount(text));
            N--;
        }
        
    }
}