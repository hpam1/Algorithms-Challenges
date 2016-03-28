package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/merging-communities
 * 
 */
public class MergingCommunities {
    private static class DisjointSet {
        private int[] p;
        private int[] count;
        
        public DisjointSet(int n) {
            this.p = new int[n];
            this.count = new int[n];
            for(int i = 0; i < n; i++) {
                p[i] = i;
                count[i] = 1;
            }
        }
        
        public int find(int m){
            int parent = p[m];
            while(parent != p[parent]) {
                parent = p[parent];
            }
            while(m != parent) {
                int prevP = p[m];
                p[m] = parent;
                m = prevP;
            }
            return parent;
        }
        
        public int count(int m) {
            int root = find(m);
            //System.out.println(m + " root " + root + " " + count[root]);
            return count[root];
        }
        
        public void merge(int i, int j) {
            //System.out.println("merge " + i + " " + j);
            int rootI = find(i);
            int rootJ = find(j);
            //System.out.println("root I " + rootI + " rootJ " + rootJ);
            if(rootI != rootJ) {
                if(count[rootI] < count[rootJ]) {
                    p[rootI] = rootJ;
                    count[rootJ] += count[rootI];
                    //System.out.println("count J " + count[rootJ]);
                } else {
                    p[rootJ] = rootI;
                    count[rootI] += count[rootJ];
                    //System.out.println("count I " + count[rootI]);
                }
            }
        }
        
    }
    
    private DisjointSet ds;
    
    public MergingCommunities(int N) {
        ds = new DisjointSet(N);
    }
    
    public void process(String query) {
        String[] splitQry = query.split(" ");
        if(splitQry[0].equals("M")) {
            int c1 = Integer.parseInt(splitQry[1]) - 1;
            int c2 = Integer.parseInt(splitQry[2]) - 1;
            ds.merge(c1, c2);
        } else {
            int c = Integer.parseInt(splitQry[1]) - 1;
            System.out.println(ds.count(c));
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        in.nextLine();
        MergingCommunities s = new MergingCommunities(N);
        while(Q > 0) {
            Q--;
            s.process(in.nextLine());
        }
    }
}
