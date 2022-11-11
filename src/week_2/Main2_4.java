package week_2;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main2_4 { //재귀함수 사용하기 카운트 다운
    public static int countDown(int num) {
        System.out.println(num);
        if (num > 0) {
            countDown(num - 1);
        }
        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        countDown(num);
    }

}
