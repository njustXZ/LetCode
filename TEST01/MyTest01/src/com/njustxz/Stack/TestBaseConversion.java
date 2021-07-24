package com.njustxz.Stack;

/**
 * 用堆栈实现进制转换
 */
public class TestBaseConversion {
    public static void main(String[] args) {
        System.out.println(convert(100,8));
    }

    /**
     * 把一个十进制数转换为decimal指定的进制数
     */
    public static String convert(int num, int decimal) {
        MyStack stack = new MyLinkStack();
        int remainder = num % decimal;
        while (num != 0) {
            stack.push(remainder);
            num = num / decimal;
            remainder = num % decimal;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}