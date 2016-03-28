package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/anagram
 * 
 */
public class Anagram2 {

    public static int getEditDistance(String str) {
        int len = str.length();
        Map<Integer, Integer> S1Map = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < len; i++) {
            int index = str.charAt(i) - 97;
            if(i < (len/2)) {
                if(S1Map.containsKey(index)) {
                    int freq = S1Map.get(index);
                    S1Map.put(index, freq + 1);
                } else {
                    S1Map.put(index, 1);
                }
            } else {
                if(S1Map.containsKey(index)) {
                    int freq = S1Map.get(index);
                    S1Map.put(index, freq - 1);
                } else {
                    count++;
                }
            }
        }
        for(int key: S1Map.keySet()) {
            if(S1Map.get(key) < 0)
                count = count + (-S1Map.get(key));
            else
                count = count + S1Map.get(key);
        }
        return (count /  2);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while(N > 0) {
            String str = in.nextLine();
            if(str.length() %2 != 0)
                System.out.println("-1");
            else
                System.out.println(getEditDistance(str));
            N--;
        }
        
    }
}