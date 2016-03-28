package practice.hackerrank;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/common-child
 * 
 */
public class CommonChild {
    static int[][] lcsMap;
    static char[] s1Arr;
    static char[] s2Arr;
    
    static int getLCSLen(int i, int j) {
        if(i < 0 || j < 0)
            return 0;
        if(lcsMap[i][j] > -1) {
            return lcsMap[i][j];
        }        
        
        if(s1Arr[i] == s2Arr[j]) {
            int val = 1 + getLCSLen(i-1, j-1);
            lcsMap[i][j] = val;
            return val;
        } else {
            int val1 = getLCSLen(i, j-1);
            int val2 = getLCSLen(i-1, j);
            int val = 0;
            if(val1 >= val2)
                val = val1;
            else
                val = val2;
            lcsMap[i][j] = val;
            return val;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        s1Arr = in.nextLine().toCharArray();
        s2Arr = in.nextLine().toCharArray();
        lcsMap = new int[s1Arr.length][s2Arr.length];
        for(int i = 0; i < s1Arr.length; i++) {
            for(int j = 0; j < s2Arr.length; j++) {
                lcsMap[i][j] = -1;
            }
        }
        System.out.println(getLCSLen(s1Arr.length-1, s2Arr.length-1));
    }
}