import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0) {
            System.out.println(0);
        } else {
            convert(num);
            System.out.println();
        }
    }

    /*
    진수 변환법
    2진수일 때,
    10 = 2*5 + 0
    5 = 2*2 + 1
    2 = 2*1 + 0
    1 = 2*0 + 1
    이에 따라, 10을 2진수로 표현하면 1010이된다.

    -2진수도 위와 같은 진수 변환법을 사용하면 된다.
    다만 주의할 점은 음수/음수인 경우의 처리이다.
    이 경우에만 나머지가 -1이 나오기 때문에 다르게 처리해주어야 한다.
    (나머지를 1로 만들기 위해서는 몫이 1만큼 커져야함)
    -13 = (-2)*7 + 1 이다.
    그러나 -13/-2의 결과는 6이 나온다.
    그러므로 -13-1/-2 처리를 해주어야 정상적인 7 값이 나온다.
    -13 = -2*(7) + 1
    7 = -2*(-3) + 1
    -3 = -2*(2) + 1
    2 = -2*(-1) + 0
    -1 = -2*(1) + 1
    1 = -2*(0) + 1
     */

    public static void convert(int n) {
        if (n == 0) return; // n이 0이면 변환 끝난 것임
        if (n%2 == 0) { // n이 짝수이면
            convert(n/-2);
            System.out.print(0); // 2로 나누어 떨어지므로 0
        } else { // n이 홀수이면
            if (n>0) convert(n/-2);
            else convert((n-1)/-2); // 음수/음수인 경우 -> 처리 필요
            System.out.print(1); // 2로 나누어 떨어지지 않으므로 1
        }
    }

}
