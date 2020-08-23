package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q1935 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        int operandCount = Integer.parseInt(br.readLine()); //피연산자의 개수 입력받기

        double[] number = new double[27]; //피연산자를 담는 배열

        String line = br.readLine(); //후위 표기식 입력받기

        for(int i=0; i<operandCount; i++){ //피연산자를 입력받고 배열에 넣기
            int input = Integer.parseInt(br.readLine());
            number[i] = (float)input;
        }

        for(int i=0; i<line.length();i++){
            int code = (int)line.charAt(i);

            if(code >= 65 && code <= 90){ //알파벳이면 push()
                stack.push(number[code-65]);
            } else{ //연산기호면
                double num1 = stack.pop();
                double num2 = stack.pop();
                double result = 0;

                switch(code){
                    case 42:
                        result = num2*num1;
                        break;
                    case 43:
                        result = num2+num1;
                        break;
                    case 47:
                        result = num2/num1;
                        break;
                    case 45:
                        result = num2-num1;
                        break;
                }
                stack.push(result);
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
