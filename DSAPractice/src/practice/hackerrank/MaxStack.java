package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/maximum-element
 * 
 */
public class MaxStack {
    private static class MaxCount {
        private int max;
        private int count;
        public MaxCount(int max) {
            this.max = max;
            this.count = 1;
        }
    }
    
    private Stack<Integer> stack;
    private Stack<MaxCount> maxStack;
    private int currentMax;
    private int currentCount;
    
    public MaxStack() {
        this.stack = new Stack<Integer>();
        this.maxStack = new Stack<MaxCount>();
        this.currentMax = Integer.MIN_VALUE;
        this.currentCount = 1;
    }
    
    public void process(int operation, Integer operand) {
        switch(operation) {
            case 1:
                stack.push(operand);
                if(operand <= currentMax) {
                    MaxCount m = maxStack.peek();
                    m.count++;
                    currentCount++;
                } else {
                    MaxCount m = new MaxCount(operand);
                    currentMax = operand;
                    currentCount = 1;
                    maxStack.push(m);
                }
            break;
            case 2:
                stack.pop();
                MaxCount m1 = maxStack.peek();
                m1.count--;
                currentCount--;
                if(currentCount == 0)
                    maxStack.pop();
                if(!maxStack.isEmpty()) {
                    m1 = maxStack.peek();
                	currentMax = m1.max;
                    currentCount = m1.count;
                } else {
                    currentMax = Integer.MIN_VALUE;
                    currentCount = 1;
                }
            break;
            case 3:
                System.out.println(currentMax);
            break;
        }
    } 
    
    
    public static void main(String[] args) {
    	MaxStack s = new MaxStack();
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        while(N > 0) {
            N--;
            String[] str = in.nextLine().split(" ");
            int operation = Integer.parseInt(str[0]);
            Integer operand = null;
            if(str.length > 1)
                operand = Integer.parseInt(str[1]);
            s.process(operation, operand);
        }
    }
}
