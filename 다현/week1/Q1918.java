package week1;

import java.util.Scanner;
import java.util.Stack;

public class Q1918 {
    static int precedence(char ch) { //연산자의 우선순위를 정해준다
        if (ch == '(') return 0;
        if (ch == '+' || ch == '-') return 1;
        else return 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = ""; //결과값을 담는 문자열
        Stack<Character> ops = new Stack<>();

        for (char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') { //연산자가 아닌 경우 결과값에 바로 넣는다
                ans += ch;
            } else if (ch == '(') { //'('는 스택에 바로 넣는다
                ops.push(ch);
            } else if (ch == ')') { //'('를 만날 때 까지 스택에서 pop해서 결과값에 넣는다
                while (!ops.isEmpty()) {
                    char op = ops.pop();
                    if (op == '(') break;
                    ans += op;
                }
            } else { //'('나 ')'가 아닌 연산자의 경우. 연산자의 우선순위가 높은 경우에만 스택에 넣는다
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(ch)) {
                    ans += ops.pop();
                }
                ops.push(ch);
            }
        }
        while (!ops.isEmpty()) { //문자열 탐색 후 스택에 연산자가 남아있으면 전부 pop해서 결과값에 넣는다
            ans += ops.pop();
        }
        System.out.println(ans);
    }
}