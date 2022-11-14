package week_1;

import java.util.Scanner;

public class Main1_7 {
    // 문자열 뒤집기
    // 0과 1로만 이루어진 문자열이 주어졌을 때,
    // 이 문자열에 있는 모든 숫자를 전부 같게 만들려고 한다.
    // 할 수 있는 행동은 문자열에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
    // 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
    // 예를 들어 S=0001100 일때, 1111111을 만드려면 0의 묶음 2개를 뒤집어야 된다.
    // 0000000을 만들면 11만 한번 뒤집으면 되므로 최소 횟수는 1이다.
    // 주어진 문자열을 모두 0 혹은 모두 1로 같게 만드는 최소 횟수를 반환하시오.
    public static int minCount(String str) {
        int cntMakeAllZero= 0;
        int cntMakeAllOne = 0;

        if(str.charAt(0) == 1)
            cntMakeAllZero++;

        if(str.charAt(0) == 0)
            cntMakeAllOne++;

        for(int i = 0; i < str.length() - 1; i++) {
            if(str.charAt(i) == '0' && str.charAt(i+1) == '1') {
                cntMakeAllZero++;
            }
            else if(str.charAt(i) == '1' && str.charAt(i+1) == '0') {
                cntMakeAllOne++;
            }
        }

        return Math.min(cntMakeAllOne, cntMakeAllZero);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(minCount(str));
    }
}
