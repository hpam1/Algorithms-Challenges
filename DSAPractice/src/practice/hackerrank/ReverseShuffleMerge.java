package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 
 * https://www.hackerrank.com/challenges/reverse-shuffle-merge
 * 
 */
public class ReverseShuffleMerge {
    private char[] A;
	private int[] charCount;
	private String S;
	private int checkCount;
	
	public ReverseShuffleMerge(String S) {
		this.S = S;
		this.charCount = new int[26];
		for(int i = 0; i < 26; i++) {
			charCount[i] = 0;
		}
		this.A = new char[S.length()/2];
		this.checkCount = 0;
	}
	
	private void preprocess() {
		for(int i = 0; i < S.length(); i++) {
			int index = S.charAt(i) - 97;
			charCount[index]++;
		}
		for(int i = 0; i < 26; i++) {
			charCount[i] = charCount[i] / 2;
			if(charCount[i] != 0)
				checkCount++;
		}
	}
	
	public String getLexicalA() {
		preprocess();
		for(int i = 0; i < A.length; i++) {
			int j = 0;
			while(true) {
				while(charCount[j] == 0)
					j++;
				A[i] = (char) (97 + j);
				charCount[j]--;
				if(isValid(j)) {
					break;
				}
				charCount[j]++;
				j++;
			}
			if(checkCount == 0)
				break;
			int index = S.indexOf(97 + j);
			S = S.substring(index + 1);
		}
		return new String(A);
	}
	
	private boolean isValid(int j) {
		if(charCount[j] == 0 && checkCount - 1 == 0) {
			checkCount--;
			return true;
		}
		
		int charIndex = S.indexOf(97 + j);
		String tempS = S.substring(charIndex+1);
		int[] tempCount = new int[26];
		for(int i = 0; i < 26; i++) {
			tempCount[i] = 0;
		}
		for(int i = 0; i < tempS.length(); i++) {
			int index = tempS.charAt(i) - 97;
			tempCount[index]++;
		}
		for(int i = 0; i < 26; i++) {
			if(charCount[i] > tempCount[i])
				return false;
		}
		if(charCount[j] == 0)
			checkCount--;
		return true;
	}
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str = new StringBuilder(str).reverse().toString();
        ReverseShuffleMerge sol = new ReverseShuffleMerge(str);
        System.out.println(sol.getLexicalA());
    }
}