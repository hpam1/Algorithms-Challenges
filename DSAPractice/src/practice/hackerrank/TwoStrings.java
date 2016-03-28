package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/two-strings
 * 
 */
public class TwoStrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while(T > 0) {
            String A = in.nextLine();
            String B = in.nextLine();
            Set<Integer> aSet = new HashSet<Integer>();
            for(int i = 0; i < A.length(); i++) {
                aSet.add(A.charAt(i) - 97);
            }
            for(int i = 0; i <= B.length(); i++) {
                if(i == B.length())
                    System.out.println("NO");
                else
                    if(aSet.contains(B.charAt(i) - 97)) {
                        System.out.println("YES");
                        break;
                    }
            }
            T--;
        }
    }
}