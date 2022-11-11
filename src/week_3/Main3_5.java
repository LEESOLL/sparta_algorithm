package week_3;

public class Main3_5 { //병합 정렬 구현하기
    public static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int a_index = 0;
        int b_index = 0;
        int c_index = 0;
        while (a_index < a.length && b_index < b.length) {
            if(a[a_index] < b[b_index])
                c[c_index++] = a[a_index++];
            else
                c[c_index++] = b[b_index++];
        }
        if(a_index < a.length) {
            for(int i = a_index; i < a.length; i++)
                c[c_index++] = a[i];
        }
        if(b_index < b.length) {
            for(int i = b_index; i < b.length; i++)
                c[c_index++] = b[i];
        }

        return c;
    }

    public static int[] merge_sort(int[] arr) {
        int mid = arr.length / 2;
        //병합정렬 코드 구현하기
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 6, 8, 7, 4};

        for(int x : merge_sort(arr))
            System.out.println(x);
    }
}
