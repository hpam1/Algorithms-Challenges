package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/gem-stones
 * 
 */
public class GemStones {
    private static class ElementIO {
        private int[] elementPresence;
        private int count;
        
        public ElementIO(int count) {
            this.count = count;
            elementPresence = new int[count];
            for(int i = 0; i < count; i++) {
                elementPresence[i] = 0;
            }
        }
    }
    
    private Map<Integer, ElementIO> elementMap;
    private int gemElementCount;
    private int noOfRocks;
    
    public GemStones(int noOfRocks) {
        this.noOfRocks = noOfRocks;
        this.gemElementCount = 0;
        this.elementMap = new HashMap<Integer, ElementIO>();
    }
    
    public void processStr(String str, int rockNo) {
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(elementMap.containsKey(ch-97)) {
                ElementIO el = elementMap.get(ch-97);
                if(el.elementPresence[rockNo] == 0) {
                    el.elementPresence[rockNo] = 1;
                    el.count--;
                    if(el.count == 0)
                        gemElementCount++;
                } 
            } else {
                if(rockNo == 0) {
                    ElementIO el = new ElementIO(noOfRocks);
                    el.elementPresence[rockNo] = 1;
                    el.count--;
                    elementMap.put(ch-97, el);
                    if(el.count == 0)
                        gemElementCount++;
                }
            }
        }
    }
    
    public int getGemElementCount() {
        return this.gemElementCount;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        GemStones sol = new GemStones(T);
        int i = 0;
        while(T > 0) {
            String str = in.nextLine();
            sol.processStr(str, i);
            i++;
            T--;
        }
        System.out.println(sol.getGemElementCount());
    }
}