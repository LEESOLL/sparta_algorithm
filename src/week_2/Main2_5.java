package week_2;

import java.util.Scanner;

public class Main2_5 { //재귀함수로 팩토리얼 함수 만들기
    public static int factorial(int num) {
        if (num > 1)
            return num * factorial(num - 1);
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(factorial(num));
    }
}
