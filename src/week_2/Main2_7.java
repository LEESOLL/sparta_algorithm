package week_2;

import java.util.Scanner;

public class Main2_7 { //팰린드롬 재귀함수로 구현하기
    public static boolean isPalindrome(String str) {
        if(str.length() <= 1)
            return true;
        if(str.charAt(0) == str.charAt(str.length()-1)){
            str = str.substring(1,str.length()-1);
            return isPalindrome(str);
        } else return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(isPalindrome(str));
    }
}
