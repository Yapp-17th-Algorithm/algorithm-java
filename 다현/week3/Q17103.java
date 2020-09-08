package week3;

import java.io.*;

public class Q17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] primeNum = new boolean[1000001];

        for(int i=2; i<Math.sqrt(1000001); i++){ //2~n 돌면서 검사
            for(int j=2; i*j<1000001; j++){ // 소수가 아닌 수를 true로 변경
                if(primeNum[i*j]) // 검사가 되어있다면 넘어감
                    continue;

                //검사가 안되어있다면 true값을 넣음
                primeNum[i*j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int i=3; i<=n/2; i++){ // 수가 겹치지 않도록 n의 절반만 확인한다
                if(!primeNum[i]&& !primeNum[n-i])
                    cnt ++;
            }
            bw.write(cnt+"\n");
        }
        br.close();
        bw.flush();
        bw.close();

    }
}
