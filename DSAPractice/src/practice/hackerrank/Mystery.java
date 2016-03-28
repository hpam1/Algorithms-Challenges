package practice.hackerrank;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/the-love-letter-mystery
 * 
 */
public class Mystery {

    static int getPalindromeDist(String str) {
        int len = str.length();
        int i = 0;
        int j = (len - 1);
        int distance = 0;
        while(i < j) {
            int ch1 = str.charAt(i) - 97;
            int ch2 = str.charAt(j) - 97;
            if(ch1 < ch2) {
                distance += (ch2 - ch1);
            } else if(ch2 < ch1) {
                distance += (ch1 - ch2);
            }
            i++;
            j--;
        }
        return distance;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while(T > 0) {
            String str = in.nextLine();
            System.out.println(getPalindromeDist(str));
            T--;
        }
    }
}