package hr.wofc21;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * https://www.hackerrank.com/contests/w21/challenges/luck-balance
 */
public class LuckBalance {
        
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        ArrayList<Integer> luck = new ArrayList<Integer>();
        int luckScore = 0;
        while(N > 0) {
            in.nextLine();
            int l = in.nextInt();
            int important = in.nextInt();
            if(important == 0) {
                luckScore += l;
            } else {
                luck.add(l);
            }
            N--;
        }
        Collections.sort(luck, Collections.reverseOrder());
        int i = 0;
        int n = luck.size();
        while(K > 0 && i < n) {
            luckScore += luck.get(i);
            K--;
            i++;
        }
        while(i < n) {
            luckScore -= luck.get(i);
            i++;
        }
        System.out.println(luckScore);
    }
}