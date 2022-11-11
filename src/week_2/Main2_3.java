package week_2;

import java.util.Scanner;

public class Main2_3 { //무작위로 나열된 원소를 가진 배열 이진탐색
    public static boolean binarySearch(int target, int[] arr) { //target 이 arr에 존재하는지 판별
        // sorting 하기
        for(int i = 0; i < arr.length; i++) {
            for(int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

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
        int[] arr = {0, 3, 5, 6, 1, 2, 4};

        System.out.println(binarySearch(target, arr));
    }
}
