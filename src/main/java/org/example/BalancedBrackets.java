package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println(balancedParentheses("s(fjsakj(fhs)a)"));
        System.out.println(balancedBrackets("{ksjdhfasj}fdlksa(jlk)"));
        System.out.println(balancedBrackets2("ksjdhfasj}fdlksa(jlk)"));
    }

    public static boolean balancedParentheses(String str) {
        int open = 0;
        int close = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else if (str.charAt(i) == ')') {
                close++;
                if (close > open) {
                    return false;
                }
            }
        }
        return open == close;
    }
    // the runtime for both of these should be linear

    public static boolean balancedBrackets(String str) {
        int openBrackets = 0;
        int closedBrackets = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
                openBrackets++;
            } else if (str.charAt(i) == ')' || str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == '>') {
                closedBrackets++;
                if (closedBrackets > openBrackets) {
                    return false;
                }
            }
        }
        return openBrackets == closedBrackets;
    }

    public static boolean balancedBrackets2(String string) {
        Map<Character, Character> bracketPairs = new HashMap<>();
        bracketPairs.put('(', ')');
        bracketPairs.put('[', ']');
        bracketPairs.put('{', '}');
        bracketPairs.put('<', '>');

        Stack<Character> stack = new Stack<>();

        for (char c : string.toCharArray()) {
            if (bracketPairs.containsKey(c)) {
                stack.push(c);
            } else if (bracketPairs.containsValue(c)) {
                if (stack.isEmpty() || bracketPairs.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

