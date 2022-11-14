package week_1;
import java.util.*;

public class Main1_6 { //소수 나열하기
    public static ArrayList<Integer> solution(int n) {
        ArrayList<Integer> primeList = new ArrayList<>();
        for(int i = 2; i < n + 1; i++) {
            int count = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0){
                    count++;
                }
            }
            if (count == 2)
                primeList.add(i);
        }

        return primeList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(solution(n));
    }
}
