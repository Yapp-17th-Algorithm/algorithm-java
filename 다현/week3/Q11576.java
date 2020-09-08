package week3;

import java.util.Scanner;
import java.util.Stack;

public class Q11576 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int cnt = scan.nextInt();
        int[] arr = new int[cnt];

        for(int i= cnt-1; i>=0; i--){
            arr[i] = scan.nextInt();
        }

        int result = 0;
        for(int i = 0; i<cnt; i++){
            result += (arr[i]*Math.pow(a,i));
        }

        Stack<Integer> stack = new Stack<Integer>();
        while(result != 0){
            stack.add(result % b);
            result = result/b;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }
}
