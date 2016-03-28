package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/alternating-characters
 * 
 *
 */
public class AlternatingCharacters {

    public static int getModificationCount(String str) {
        int count = 0;
        char ch = str.charAt(0);
        int startIndex = 0;
        str = str + "#";
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == ch)
                continue;
            else {
                int diff = i - startIndex;
                if(diff > 1)
                    count = count + diff - 1;
                startIndex = i;
                ch = str.charAt(i);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while(T > 0) {
            String str = in.nextLine();
            System.out.println(getModificationCount(str));
            T--;
        }
    }
}