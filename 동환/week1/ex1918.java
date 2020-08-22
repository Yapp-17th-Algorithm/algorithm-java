package donghwan.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex1918 {
    public static void main(String[] args) throws IOException {
        final char ADD = '+';
        final char SUB = '-';
        final char MUL = '*';
        final char DIV = '/';
        final char OPEN = '(';
        final char CLOSE = ')';
        Stack<Character> stack = new Stack();
        StringBuffer resultStringBuffer = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numericalString = br.readLine();
        for (char ch : numericalString.toCharArray()) {
            if (ch == ADD || ch == SUB) {
                while (!stack.isEmpty()) {
                    if (stack.peek() == OPEN) break;
                    resultStringBuffer.append(stack.pop());
                }
                stack.push(ch);
            } else if (ch == CLOSE) {
                while (!stack.isEmpty()) {
                    char popChar = stack.pop();
                    if (popChar == OPEN) break;
                    resultStringBuffer.append(popChar);
                }

            } else if (ch == MUL || ch == DIV) {
                while (!stack.isEmpty()) {
                    char peekChar = stack.peek();
                    if ((peekChar == ADD) || (peekChar == SUB) || (peekChar == OPEN)) break;
                    resultStringBuffer.append(peekChar);
                    stack.pop();
                }
                stack.push(ch);
            } else if (ch == OPEN) {
                stack.push(ch);
            } else {
                resultStringBuffer.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            resultStringBuffer.append(stack.pop());
        }

        System.out.println(resultStringBuffer.toString());
        br.close();
    }
}

