package timeattack;

import java.util.Scanner;

public class Main3 { //369게임
    public static int solution(int order) {
        int answer = 0;
        String tmp = String.valueOf(order);
        for(int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '3')
                answer++;
            else if(tmp.charAt(i) == '6')
                answer++;
            else if(tmp.charAt(i) == '9')
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int order = sc.nextInt();

        System.out.println(solution(order));
    }
}
