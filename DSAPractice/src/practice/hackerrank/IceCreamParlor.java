package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/icecream-parlor
 * 
 *
 */
public class IceCreamParlor {
    private static class Icecream implements Comparable<Icecream> {
        private int id;
        private int price;
        public Icecream(int id, int price) {
            this.id = id;
            this.price = price;
        }
        public int compareTo(Icecream i) {
            return this.price - i.price;
        }
    }
    
    private static String search(Icecream[] icecream, int M) {
        Arrays.sort(icecream);
        int N = icecream.length;
        for(int i = 0; i < N; i++) {
            int price = icecream[i].price;
            int index = binarySearch(icecream, M - price);
            if(index != -1) {
                int id1 = icecream[i].id;
                int id2 = icecream[index].id;
                if(id1 < id2)
                   return id1 + " " + id2;
                else
                    return id2 + " " + id1;
            }
        }
        return "-1 -1";
    }
    
    private static int binarySearch(Icecream[] icecream, int value) {
        int low = 0;
        int high = icecream.length - 1;
        int middle = 0;
        while(low <= high) {
            middle = low + ((high - low + 1) / 2);
            if(icecream[middle].price == value)
                return middle;
            else if(icecream[middle].price < value) {
                low = middle + 1;
            } else
                high = middle - 1;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        while(T > 0) {
            int M = Integer.parseInt(in.nextLine());
            int N = Integer.parseInt(in.nextLine());
            Icecream[] icecreams = new Icecream[N];
            String[] prices = in.nextLine().split(" ");
            for(int i = 0; i < N; i++) {
                Icecream ic = new Icecream(i+1, Integer.parseInt(prices[i]));
                icecreams[i] = ic;
            }
            System.out.println(search(icecreams, M));
            T--;
        }
    } 
}