package donghwan.week1;

import java.util.Scanner;
import java.util.Stack;

public class ex1935 {
    public static void main(String[] args) {
        final double baseCharValue = 'A';
        Scanner sc = new Scanner(System.in);
        Stack<Double> stack = new Stack<>();
        int operandCount = sc.nextInt();
        String numericalString = sc.next();
        Double[] operandValue = new Double[operandCount];
        for (int i = 0; i < operandCount; i++) {
            operandValue[i] = sc.nextDouble();
        }

        for (int i = 0; i < numericalString.length(); i++) {
            char ch = numericalString.charAt(i);
            if (ch == '+') {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                stack.push(operand2 + operand1);
            } else if (ch == '-') {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                stack.push(operand2 - operand1);
            } else if (ch == '*') {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                stack.push(operand2 * operand1);
            } else if (ch == '/') {
                double operand1 = stack.pop();
                double operand2 = stack.pop();
                stack.push(operand2 / operand1);
            } else {
                stack.push(operandValue[(int) (ch - baseCharValue)]);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
