package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor
 * 
 */
public class SimpleTextEditor {
    private Stack<String> editorStack;
    private StringBuilder currentStr;
    
    public SimpleTextEditor() {
        editorStack = new Stack<String>();
        this.currentStr = new StringBuilder();
    }
    
    public void process(int operation, String operand) {
        int k = 0;
        String prev = null;
        switch(operation) {
            case 1:
                currentStr.append(operand);    
                editorStack.push(currentStr.toString());
                break;
            case 2:
                k = Integer.parseInt(operand);
                currentStr.delete(currentStr.length() - k, currentStr.length());
                editorStack.push(currentStr.toString());
                break;
            case 3:
                k = Integer.parseInt(operand);
                System.out.println(currentStr.charAt(k-1));
                break;
            case 4:
                editorStack.pop();
                if(!editorStack.isEmpty())
                    currentStr = new StringBuilder(editorStack.peek());
                else
                    currentStr = new StringBuilder();
                break;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SimpleTextEditor s = new SimpleTextEditor();
        int Q = Integer.parseInt(in.nextLine());
        while(Q > 0) {
            Q--;
            String[] str = in.nextLine().split(" ");
            int op = Integer.parseInt(str[0]);
            //System.out.println(str.length);
            if(str.length > 1)
                s.process(op, str[1]);
            else
                s.process(op, null);
        }
    }
}