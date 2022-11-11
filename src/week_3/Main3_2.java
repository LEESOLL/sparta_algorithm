package week_3;

public class Main3_2 { //선택 정렬 구현하기
     public static int[] selectSort(int[] arr) {
         int n = arr.length;
         for(int i = 0; i < n - 1; i++) {
             int idx = i;
             for(int j = i+1; j < n; j++) {
                 if(arr[idx] > arr[j]) {
                     idx = j;
                 }
                 int tmp = arr[i];
                 arr[i] = arr[idx];
                 arr[idx] = tmp;
             }
         }

         return arr;
     }

    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 9, 1};

        System.out.println(selectSort(arr));
    }
}
