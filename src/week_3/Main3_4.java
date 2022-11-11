package week_3;

import java.util.Arrays;

public class Main3_4 { //정렬을 마친 배열의 정렬 구현하기
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

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 5};
        int[] b = {4, 6, 7, 8};

        for(int x : merge(a, b))
            System.out.println(x);
    }
}
