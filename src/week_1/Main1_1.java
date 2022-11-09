package week_1;

public class Main1_1 {
//최댓값 찾기
    public static int findMaxNum (int[] array) {
        int answer = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > answer) {
                answer = array[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 6, 1, 2, 4};

        System.out.println(findMaxNum(arr));
    }
}
