package timeattack;

import java.util.Scanner;

public class Main2 { //옷가게
    public static int solution(int price) {
        int answer = price;

        if(price >= 500000)
            answer = (int) (price * 0.8);
        else if(price >=300000)
            answer = (int) (price * 0.9);
        else if(price >= 100000)
            answer = (int) (price * 0.95);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();

        System.out.println(solution(price));
    }
}
