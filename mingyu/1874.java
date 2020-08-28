import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int pointer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for (int i=0;i<n;i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int x : array) {
            if (stack.peek() < x) {
                for (int i=pointer;i<x;i++) {
                    stack.push(i+1);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
                pointer = x;

            } else if (stack.peek() == x) {
                stack.pop();
                sb.append("-\n");

            } else {
                System.out.print("NO");
                return;
            }
        }
        System.out.print(sb);
    }
}
