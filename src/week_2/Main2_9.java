package week_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2_9 {
    // <배달의 민족 배달 가능 여부 판단>
    // 상점에서 현재 가능한 메뉴가["떡볶이", "만두", "오뎅", "사이다", "콜라"] 일 때,
    // 유저가 ["오뎅", "콜라", "만두"]를 주문했다.
    // 그렇다면, 현재 주문 가능한 상태인지 여부를 반환해라.
    public static boolean orderAvailable(ArrayList<String> order) {
        int index = 0;
        List<String> menu = new ArrayList<>(Arrays.asList("떡볶이", "만두", "오뎅", "사이다", "콜라"));
        while(index < order.toArray().length){
            if(menu.contains(order.get(index))) {
                index++;
            }
            else return false;
        }
        if(index == order.size())
            return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> order = new ArrayList<>(Arrays.asList("오뎅", "콜라", "만두"));

        System.out.println(orderAvailable(order));
    }
}
