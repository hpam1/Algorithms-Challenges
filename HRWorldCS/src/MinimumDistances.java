import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Problem:
 * https://www.hackerrank.com/contests/june-world-codesprint/challenges/minimum-distances
 *
 */
public class MinimumDistances {
    private static class MyArr implements Comparable<MyArr> {
        private int no;
        private int pos;
        public MyArr(int no, int pos) {
            this.no = no;
            this.pos = pos;
        }
        
        public int getNo() {
            return this.no;
        }
        public int getPos() {
            return this.pos;
        }
        public int compareTo(MyArr m) {
            return this.no - m.getNo();
        }
        
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<MyArr> arrList = new ArrayList<MyArr>();
        for(int i=0; i < n; i++){
            int no = in.nextInt();
            MyArr ma = new MyArr(no, i);
            arrList.add(ma);
        }
        Collections.sort(arrList);
        int minDist = Integer.MAX_VALUE;
        boolean flag = false;
        for(int i = 1; i < n; i++) {
            if(arrList.get(i).getNo() == arrList.get(i-1).getNo()) {
                int dist = (int) Math.abs(arrList.get(i).getPos() - arrList.get(i-1).getPos());
                if(dist < minDist)
                    minDist = dist;
                flag = true;
            }
        }
        if(!flag)
            minDist = -1;
        System.out.println(minDist);
    }
}
