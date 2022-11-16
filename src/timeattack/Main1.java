package timeattack;

import java.util.Scanner;

public class Main1 { //각도기
    public static int solution(int angle) {
        int answer = 0;

        if (angle > 0 && angle < 90) answer = 1;
        else if (angle == 90) answer = 2;
        else if (angle > 90 && angle < 180) answer = 3;
        else if (angle == 180) answer = 4;

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle = sc.nextInt();

        System.out.println(solution(angle));
    }
}
