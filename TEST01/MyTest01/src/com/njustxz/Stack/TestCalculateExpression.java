package com.njustxz.Stack;

import java.awt.image.PackedColorModel;

/**
 * 用栈模拟四则运算
 * 定义两个栈，一个存数字，一个存符号
 * 读取表达式，假如是操作数就把数据存入数栈
 * 假如是操作符：
 * 1)符号为空则入栈
 * 2）符号不空则与前一符号比较，
 * 当前符号优先级高，操作符入栈
 * 当前符号优先级低，弹出栈顶运算符，从数栈中取出两个数运算，把结果返回数栈，继续比较剩下的符号
 * 遍历完整个表达式，两个栈都不为空，依次弹出符号栈与数栈的数字，再把结果返回
 * 假如符号栈不为空，或者数栈大于1，则运算错误。
 */
public class TestCalculateExpression {
    public static void main(String[] args) throws Exception {
        //使用栈计算算术表达式的值
        String expression = "44+3+(6-10+2*3)*4";
        String result = calculater(expression);
        System.out.println(result);
    }

    //定义方法计算指定表达式的值
    public static String calculater(String expression) throws Exception {
        MyStack numStack = new MyArrayStack();
        MyStack operaStack = new MyLinkStack();
        for (int i = 0; i < expression.length(); i++) {
            char cc = expression.charAt(i);
            //取出操作数，需要考虑操作数是多位的，还是个位的
            if (Character.isDigit(cc)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(cc)) {
                    sb.append(cc);
                    i++;
                    if (i >= expression.length()) {
                        break;
                    }
                    cc = expression.charAt(i);
                }
                numStack.push(sb.toString());
                //修正i变量的值
                i--;
                System.out.println(sb);
            } else {
                //取出操作符
                //1)栈为空，直接把符号入栈
                //2）栈不为空，取出栈中运算符并与当前运算符的比较优先级
                //3）当前运算符优先级高，将当前运符入栈，否则，取出数栈数字将栈中运算符
                //运算符优先级比较情况优先级高，优先级相等（左右括弧），优先级低
                if (operaStack.isEmpty()) {
                    operaStack.push(cc);
                    continue;
                }
                while (!operaStack.isEmpty()) {
                    char op1 = (char) operaStack.peak();
                    if (compareOperator(op1, cc) < 0) {
                        //优先级低
                        operaStack.push(cc);
                        break;
                    } else if (compareOperator(op1, cc) == 0) {
                        //优先级相等
                        operaStack.pop();
                        break;
                    } else { //栈顶运算符号优先级高，可能需要判断多次
                        //取出数据和运算符，进行运算
                        double num1 = Double.parseDouble(numStack.pop().toString());
                        double num2 = Double.parseDouble(numStack.pop().toString());
                        char operator = (char) operaStack.pop();
                        //计算 num2 op num1
                        double result = compute(operator, num1, num2);
                        //把结果存储到操作数栈中
                        numStack.push(result);
                        if (operaStack.isEmpty()) {
                            operaStack.push(cc);
                            break;
                        }
                    }
                }
            }
        }

        while(!operaStack.isEmpty()){
            double num1 = Double.parseDouble(numStack.pop().toString());
            double num2 = Double.parseDouble(numStack.pop().toString());
            char operator = (char) operaStack.pop();
            double result = compute(operator,num1,num2);
            numStack.push(result);
        }
        if(numStack.getSize()>1){
            throw new Exception("表达式错误！！");
        }
        return  numStack.peak().toString();
    }

    private static double compute(char operator, double num1, double num2) {
        switch (operator) {
            case '+':
                return num2 + num1;
            case '-':
                return num2 - num1;
            case '*':
                return num2 * num1;
            case '/':
                return num2 / num1;
        }
        return 0;
    }

    private static int compareOperator(char op1, char cc) {
        if (op1 == '+' || op1 == '-') {
            if (cc == '*' || cc == '/' || cc == '(') {
                return -1;
            }
        }
        if (op1 == '*' || op1 == '/') {
            if (cc == '(') {
                return -1;
            }
        }
        if (op1 == '(') {
            if (cc == ')') {
                return 0;
            } else {
                return -1;
            }
        }
        return 1;
    }
}
