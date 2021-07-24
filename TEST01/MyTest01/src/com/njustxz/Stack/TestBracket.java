package com.njustxz.Stack;

/**
 * 检测表达式中括弧是否匹配
 * 假设表达式中包含三种括弧：小，中，大，可以任意嵌套
 * 算法：读取整个表达式，假设左括号直接入栈，等待与之对应的右括弧出现
 * 假设右括弧与栈顶的左括弧不匹配，则说明不合法，
 * 假设右括弧出现，栈已空；假设已读完，栈未空，不合法。
 */
public class TestBracket {
    public static void main(String[] args) {
        String abc="{(({{[[]]}}))}";
        System.out.println(bracketMatch(abc));
        System.out.println(bracketMatch("{}{()()()[[]}"));
    }

    public static boolean bracketMatch(String expression) {
        MyStack stack = new MyArrayStack();
        //遍历表达式
        for (int i = 0; i < expression.length(); i++) {
            char cc = expression.charAt(i);
            switch (cc) {
                case '(':
                case '[':
                case '{':
                    stack.push(cc);
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.pop().equals('{')) {
                        break;
                    } else {
                        return false;
                    }
                case ']':
                    if (!stack.isEmpty() && stack.pop().equals('[')) {
                        break;
                    } else {
                        return false;
                    }
                case ')':
                    if (!stack.isEmpty() && stack.pop().equals('(')) {
                        break;
                    } else {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
