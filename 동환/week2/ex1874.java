package week2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ex1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> temp = new Stack();
        ArrayList<String> result = new ArrayList<>();
        int length = sc.nextInt();
        int[] target = new int[length];
        for (int i = 0; i < length; i++) {
            target[i] = sc.nextInt();
        }

        https://github.com/Yapp-17th-Algorithm/algorithm-java.git

        int targetCount = 0;
        int number = 1;
        while (targetCount <= length - 1) {
            if (temp.size() > 0 && temp.peek() == target[targetCount]) {
                temp.pop();
                result.add("-");
                targetCount++;
            } else if (number <= target[targetCount]) {
                temp.push(number++);
                result.add("+");
            } else {
                result.add("NO");
                break;
            }
        }

        if (result.contains("NO")) {
            System.out.println("NO");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        }
    }
}
