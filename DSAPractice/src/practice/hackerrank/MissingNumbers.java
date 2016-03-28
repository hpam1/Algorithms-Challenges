package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/missing-numbers
 */
public class MissingNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] aStr = in.nextLine().split(" ");
        int m = Integer.parseInt(in.nextLine());
        String[] bStr = in.nextLine().split(" ");
        int[] cache = new int[100];
        for(int i = 0; i < 100; i++) {
            cache[i] = 0;
        }
        int min = 10001;
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(bStr[i]);
            if(value < min)
                min = value;
            if(min == 1)
                break;
        }
        for(int i = 0; i < m; i++) {
            int value = Integer.parseInt(bStr[i]);
            int index = value - min;
            cache[index]++;
        }
        for(int j = 0; j < n; j++) {
            int value = Integer.parseInt(aStr[j]);
            int index = value - min;
            cache[index]--;
        }
        for(int i = 0; i < 100; i++) {
            if(cache[i] != 0) {
                int value = min + i;
                System.out.print(value + " ");
            }
        }
    }
}