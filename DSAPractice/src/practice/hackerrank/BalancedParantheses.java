package practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * https://www.hackerrank.com/challenges/balanced-parentheses
 * 
 */
public class BalancedParantheses {
    private static final char opara1 = '{';
    private static final char opara2 = '(';
    private static final char opara3 = '[';
    private static final char cpara1 = '}';
    private static final char cpara2 = ')';
    private static final char cpara3 = ']';
    
    public boolean isValid(String expression) {
        Stack<Character> paranthesisStack = new Stack<Character>();
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            switch(ch) {
                case opara1:
                    paranthesisStack.push(ch);
                    break;
                case opara2:
                    paranthesisStack.push(ch);
                    break;
                case opara3:
                    paranthesisStack.push(ch);
                    break;
                case cpara1:
                    if(!paranthesisStack.isEmpty() && paranthesisStack.peek() == opara1)
                        paranthesisStack.pop();
                    else
                        return false;
                    break;
                case cpara2:
                    if(!paranthesisStack.isEmpty() && paranthesisStack.peek() == opara2)
                        paranthesisStack.pop();
                    else
                        return false;
                    break;
                case cpara3:
                    if(!paranthesisStack.isEmpty() && paranthesisStack.peek() == opara3)
                        paranthesisStack.pop();
                    else
                        return false;
                    break;
            }
        }
        if(!paranthesisStack.isEmpty())
            return false;
        return true;
    }
    
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        BalancedParantheses s = new BalancedParantheses();
        while(N > 0) {
            String str = in.nextLine();
            N--;
            if(s.isValid(str))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}