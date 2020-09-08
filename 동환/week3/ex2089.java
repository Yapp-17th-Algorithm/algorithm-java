package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int baseNumber = -2;
        int targetNumber = Integer.parseInt(br.readLine());

        int number = targetNumber;
        String result = "";
        while (true) {
            int i = number % baseNumber;
            number /= baseNumber;
            if (i < 0) {
                i += Math.abs(baseNumber);
                number++;
            } else if (number == 0) {
                result = i + result;
                break;
            }
            result = i + result;
        }
        System.out.println(result);
    }
}
