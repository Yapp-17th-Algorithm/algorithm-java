import java.util.Scanner;

public class Main {
    static int[] num;
    static int A;
    static int B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();
        int m = sc.nextInt();
        num = new int[m];
        for (int i=m-1;i>=0;i--) { // 낮은 자리 수일수록 낮은 인덱스에 저장
            num[i] = sc.nextInt();
        }
        toB(to10());
        System.out.println();
    }
    /*
    1. 먼저 A진법 수를 10진법으로 바꾼다.
    2. 10진법으로 바뀐 수를 B진법으로 바꾼다.
     */

    // A진법 10진법으로 바꾸는 메소드
    public static int to10() {
        int num10 = 0;
        for (int i=0;i<num.length;i++) {
            num10 += num[i]*(int)Math.pow(A, i); // 각 자리에 맞게 A^n값 곱해서 10진수로 바꿔줌
        }
        return num10; // 10진수로 바꾼 값 저장
    }

    // 10진법 B진법으로 바꾸는 메소드
    public static void toB(int n) {
        if (n == 0) return;
        toB(n/B);
        System.out.print(n%B + " ");
    }
}