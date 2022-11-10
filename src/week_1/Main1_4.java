package week_1;

public class Main1_4 { //연산 결과가 최댓값이 되게 하는 함수
    public static int solution(int[] arr) {
        int answer = 0;

        for(int i = 0; i < arr.length; i++) {
            if (answer == 0 || answer == 1) {
                answer += arr[i];
            }
            else if(arr[i] == 1) {
                answer += arr[i];
            }
            else answer *= arr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 5, 6, 1, 2, 4};

        System.out.println(solution(arr));
    }
}
