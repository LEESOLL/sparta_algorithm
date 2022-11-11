package week_3;

public class Main3_3 { //삽입 정렬 구현하기

    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for(j = i-1; j >= 0; j--) {
                if(arr[j] > tmp)
                    arr[j + 1] = arr[j]; //큰 수를 오른쪽으로 한칸 밈
                else
                    break;
            }
            arr[j + 1] = tmp; //j반복문을 빠져나와 최종 j지점의 한칸 오른쪽에 tmp 삽입
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9, 1};

        for(int x : insertionSort(arr))
        System.out.println(x);
    }
}
