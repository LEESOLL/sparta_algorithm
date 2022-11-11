package week_3;

public class Main3_1 { //버블 정렬 구현하기

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9, 1};

        for(int x : bubbleSort(arr))
            System.out.println(x);
    }
}
