package week_2;

import java.util.Scanner;

public class Main2_2 { //이진탐색 구현
    public static boolean binarySearch(int target, int[] arr) { //target 이 arr에 존재하는지 판별
        int current_min = 0;
        int current_max = arr.length-1;
        int current_guess = (current_min + current_max) / 2;

        while(current_min <= current_max) {
            if (arr[current_guess] == target)
                return true;
            else if (arr[current_guess] < target) {
                current_min = current_guess + 1;
            }
            else if (arr[current_guess] > target) {
                current_max = current_guess - 1;
            }
            current_guess = (current_min + current_max) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println(binarySearch(target, arr));
    }
}
