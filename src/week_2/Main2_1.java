package week_2;
import java.util.*;


public class Main2_1 { //두개의 linkedlist 원소의 값 더하기

    public static int sum(LinkedList<Integer> a, LinkedList<Integer> b) {
        int num_a = get_linkedlist_sum(a);
        int num_b = get_linkedlist_sum(b);

        return num_a + num_b;
    }

    public static int get_linkedlist_sum(LinkedList<Integer> a) { //linkedlist의 원소를 더해서 100의자리로 만들어 주는 함수
        int linkedlist_sum = 0;
        for (int x : a) {
            linkedlist_sum = linkedlist_sum * 10 + x;
        }
        return linkedlist_sum;
    }


    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();

        a.add(6);
        a.add(7);
        a.add(8);

        b.add(3);
        b.add(5);
        b.add(4);

        System.out.println(sum(a,b));
    }
}
