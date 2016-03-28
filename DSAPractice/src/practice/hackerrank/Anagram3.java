package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/make-it-anagram
 * 
 */
public class Anagram3 {
    public static int getEditDist(String A, String B) {
        int[] charFreq = new int[26];
        for(int i = 0; i < 26; i++) {
            charFreq[i] = 0;
        }
        for(int i = 0; i < A.length(); i++) {
            int index = A.charAt(i) - 97;
            charFreq[index]++;
        }
        for(int i = 0; i < B.length(); i++) {
            int index = B.charAt(i) - 97;
            charFreq[index]--; 
        }
        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(charFreq[i] < 0)
                charFreq[i] = -charFreq[i];
            count = count + charFreq[i];
        }
        return count;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String B = in.nextLine();
        System.out.println(getEditDist(A, B));
    }
}