package donghwan.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String targetString = br.readLine();
        Stack stack = new Stack();
        StringBuffer result = new StringBuffer();

        boolean isTag = false;
        int size = targetString.length();
        for (int i = 0; i < size; i++) {
            char ch = targetString.charAt(i);
            if (ch == '<') {
                isTag = true;
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(ch);
            } else if (ch == '>') {
                result.append(ch);
                isTag = false;
            } else {
                if (isTag) {
                    result.append(ch);
                } else {
                    if (ch == ' ') {
                        while (!stack.isEmpty()) {
                            result.append(stack.pop());
                        }
                        result.append(ch);
                    } else {
                        stack.push(ch);
                    }
                }
            }

            if (i == size - 1) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        System.out.println(result.toString());
        br.close();
    }
}

