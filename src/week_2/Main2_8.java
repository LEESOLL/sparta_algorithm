package week_2;
import week_2.MySingleLinkedList;

import java.util.Scanner;


public class Main2_8 {
    // LinkedList 뒤에서 k번째에 있는 값 출력하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        MySingleLinkedList<Integer> list = new MySingleLinkedList<>();
        list.add(0,6);
        list.add(1,7);
        list.add(2,8);
        list.add(3,99);
        list.add(4,26);

        System.out.println(list.getFromLast(k));

    }

}
