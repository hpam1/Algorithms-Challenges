package hr.worldcs;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 
 * https://www.hackerrank.com/contests/june-world-codesprint/challenges/aorb
 *
 */
public class AorB {
    private static String[] hexBinArr = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    private static HashMap<String, Integer> binHexMap = new HashMap<String, Integer>();
    
    static {
    	for(int i = 0; i < 16; i++) {
    		binHexMap.put(hexBinArr[i], i);
    	}
    }
    
    private static StringBuilder getBinary(String A, int maxLen) {
        StringBuilder result = new StringBuilder();
        int len = A.length();
        while(maxLen > len) {
            result.append(hexBinArr[0]);
            maxLen--;
        }
        for(int i = 0; i < len; i++) {
            char ch = A.charAt(i);
            if(ch >= '0' && ch <= '9') {
                int index = ch - '0';
                result.append(hexBinArr[index]);
            } else {
                int index = 10 + (ch - 'A');
                result.append(hexBinArr[index]);
            }
        }
        return result;
    }
    
    private static String binToHex(StringBuilder A) {
        int len = A.length();
        StringBuilder result = new StringBuilder();
        boolean flag = true;
        for(int i = 0; i < len; i = i + 4) {
            String substr = A.substring(i, i+4);
            int val = binHexMap.get(substr);
            if(val >= 10) {
                flag = false;
                char ch = (char) ('A' + (val - 10));
                result.append(ch);
            } else {
                if(val == 0 && flag)
                    continue;
                flag = false;
                result.append(val);
            }
        }
        if(flag)
            return new String("0");
        return new String(result);
    }


    public static void aORb(StringBuilder A, StringBuilder B, StringBuilder C, int K) {
        int len = A.length();
        for(int i = 0; i < len; i++) {
            char aBit = A.charAt(i);
            char bBit = B.charAt(i);
            char cBit = C.charAt(i);
            if(cBit == '1') {
                if(aBit == '0' && bBit == '0') {
                    B.setCharAt(i, '1');
                    K--;
                }
            } else {
                if(aBit == '1') {
                    A.setCharAt(i, '0');
                    K--;
                } 
                if(bBit == '1') {
                    B.setCharAt(i, '0');
                    K--;
                }
            }
            if(K < 0)
                break;
        }
        if(K < 0) {
            System.out.println("-1");
            return;
        }
        for(int i = 0; i < len && K > 0; i++) {
            if(A.charAt(i) == '1' && B.charAt(i) == '0' && K >= 2) {
                A.setCharAt(i, '0');
                B.setCharAt(i, '1');
                K = K - 2;
            }
            if(A.charAt(i) == '1' && B.charAt(i) == '1') {
                A.setCharAt(i, '0');
                K--;
            }
        }
        System.out.println(binToHex(A));
        System.out.println(binToHex(B));
    }    


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        in.nextLine();
        while(Q > 0) {
            int K = Integer.parseInt(in.nextLine());
            int maxLen = 0;
            String A = in.nextLine();
            if(A.length() > maxLen)
                maxLen = A.length();
            String B = in.nextLine();
            if(B.length() > maxLen)
                maxLen = B.length();
            String C = in.nextLine();
            if(C.length() > maxLen)
                maxLen = C.length();
            StringBuilder Abin = getBinary(A, maxLen);
            StringBuilder Bbin = getBinary(B, maxLen);
            StringBuilder Cbin = getBinary(C, maxLen);
            aORb(Abin, Bbin, Cbin, K);
            Q--;
        }
    }
}