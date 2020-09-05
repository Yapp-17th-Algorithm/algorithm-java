package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex11576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] binaries = br.readLine().split(" ");
        int a = Integer.parseInt(binaries[0]);
        int b = Integer.parseInt(binaries[1]);

        int digit = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");

        int targetNumber = 0;
        for (int i = 0; i < digit; i++) {
            targetNumber += ((Math.pow(a, i) * Integer.parseInt(numbers[numbers.length - 1 - i])));
        }

        String result = "";
        while (true) {
            int i = targetNumber % b;
            targetNumber /= b;
            result = i + " " + result;
            if (targetNumber == 0) {
                break;
            }
        }
        System.out.println(result);
    }
}
