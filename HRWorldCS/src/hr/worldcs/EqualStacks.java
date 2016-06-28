package hr.worldcs;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 
 * https://www.hackerrank.com/contests/june-world-codesprint/challenges/equal-stacks
 *
 */
public class EqualStacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int[] stackHeights = new int[3];
        
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            stackHeights[0] += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            stackHeights[1] += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            stackHeights[2] += h3[h3_i];
        }
        
        int[] stackTop = new int[3];
        while((stackHeights[0] != stackHeights[1]) || (stackHeights[1] != stackHeights[2])) {
            //System.out.println(Arrays.toString(stackHeights));
            int stackNo = getMax(stackHeights);
            int top = stackTop[stackNo];
            //System.out.println(stackNo + " " + top);
            int[] stack = h1;
            if(stackNo == 1)
                stack = h2;
            else if(stackNo == 2)
                stack = h3;
            stackHeights[stackNo] -= stack[top];
            stackTop[stackNo]++;
        }
        System.out.println(stackHeights[0]);
    }
    
    private static int getMax(int[] stackHeights) {
        if(stackHeights[0] >= stackHeights[1] && stackHeights[0] >= stackHeights[2])
            return 0;
        if(stackHeights[1] >= stackHeights[0] && stackHeights[1] >= stackHeights[2])
            return 1;
        return 2;
    }
}
