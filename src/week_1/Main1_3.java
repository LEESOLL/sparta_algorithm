package week_1;

public class Main1_3 {
    public static boolean solution(int n, int[] arr) {
        boolean answer = false;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == n)
                return true;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1, 2, 4};

        System.out.println(solution(7, arr));
    }
}
