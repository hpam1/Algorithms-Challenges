package hr.wofc21;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 
 * https://www.hackerrank.com/contests/w21/challenges/lazy-sorting
 */
public class LazySorting {
    private long[] memo;
    
    public LazySorting(int n) {
        memo = new long[n+1];
        memo[0] = 1;
        memo[1] = 1;
        factorial(n);
    }
    
    private void factorial(int n) {
        for(int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] * i;
        }
    }
    
    private double getPermutationCount(int n) {
        return (1.0 * memo[n]);
    }
    
    private double getPermutationCount(int n, int[] count) {
        double num = getPermutationCount(n);
        double denom = 1.0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 1) {
                denom *= getPermutationCount(count[i]);
            }
        }
        return (num / denom);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        LazySorting sol = new LazySorting(N);
        int[] count = new int[100];
        int duplicateCount = 0;
        boolean sorted = true;
        int prev = 0;
        int i = N;
        while(N > 0) {
            int num = in.nextInt();
            if(N != i && num < prev) {
                sorted = false;
            }
            prev = num;
            count[num-1]++;
            if(count[num-1] > 1) {
                duplicateCount++;
            }
            N--;
        }
        if(sorted) {
            System.out.println(0);
            return;
        }        
        double permutationCount = 0d;
        if(duplicateCount == 0)
            permutationCount = sol.getPermutationCount(i);
        else
            permutationCount = sol.getPermutationCount(i, count);
        //System.out.println(permutationCount);
        //double p = 1.0 / permutationCount;
        double result = permutationCount;
        DecimalFormat df = new DecimalFormat("#.######");
        df.setRoundingMode(RoundingMode.CEILING);
        System.out.println(df.format(result));
    }
}