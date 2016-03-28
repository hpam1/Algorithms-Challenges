package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/components-in-graph
 *
 */
public class GraphComponents {
    public static class DisjointSet {
        private int[] id;
        private int[] count;
        private int maxSize;
        private int minSize;
        
        public DisjointSet(int N) {
            this.id = new int[N];
            this.count = new int[N];
            this.maxSize = Integer.MIN_VALUE;
            this.minSize = Integer.MAX_VALUE;
            for(int i = 0; i < N; i++) {
                id[i] = i;
                count[i] = 1;
            }
        }
        
        public int find(int m) {
            int parent = id[m];
            while(parent != id[parent]) {
                parent = id[parent];
            }
            while(m != parent) {
                int prevP = id[m];
                id[m] = parent;
                m = prevP;
            }
            return parent;
        }
        
        public void merge(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI == rootJ)
                return;
            int val = 0;
            if(count[rootI] < count[rootJ]) {
                id[rootI] = rootJ;
                count[rootJ] += count[rootI];
                val = count[rootJ];
            } else {
                id[rootJ] = rootI;
                count[rootI] += count[rootJ];
                val = count[rootI];
            }
            if(val > maxSize)
                maxSize = val;
        }
        
        public int getMinSize() {
            for(int i = 0; i < id.length; i++) {
                if(i == id[i]) {
                    if(count[i] > 1 && count[i] < minSize)
                        minSize = count[i];
                }
            }
            return minSize;
        }
    }
    
    private DisjointSet ds;
    
    public GraphComponents(int N) {
        this.ds = new DisjointSet(N);
    }
    
    public void process(int i, int j) {
        ds.merge(i-1, j-1);
    }
    
    public void printMaxMin() {
        System.out.println(ds.getMinSize() + " " + ds.maxSize);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        GraphComponents s = new GraphComponents(2 * N);
        while(N > 0) {
            in.nextLine();
            N--;
            int m = in.nextInt();
            int n = in.nextInt();
            s.process(m, n);
        }
        s.printMaxMin();
    }
}
