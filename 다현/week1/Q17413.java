package week1;

import java.util.*;

public class Q17413 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        Stack<Character> stack = new Stack<Character>();
        //태그 안인지 체크
        int check = 0;
        String input = scan.nextLine();
        StringBuilder result = new StringBuilder();

        for(char ch : input.toCharArray()){
            if(ch=='<'){
                check+=1; //태그 안
                //태그 전까지의 문자 뒤집기
                while(!stack.isEmpty()){
                    result.append(stack.pop());
                }
                result.append("<");
            } else if(ch == '>'){
                check-=1; //태그 밖
                result.append(">");
            } else if(ch == ' '){
                //공백 전까지의 문자 뒤집기
                while(!stack.isEmpty())
                    result.append(stack.pop());
                result.append(" ");
            } else{
                if(check == 0) //태그 밖
                    stack.push(ch);
                else //태그 안
                    result.append(ch);
            }
        }

        //스택에 남은 문자 뒤집기
        while(!stack.isEmpty())
            result.append(stack.pop());

        System.out.println(result);
        scan.close();
        return;
    }
}
