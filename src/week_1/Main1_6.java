package week_1;
import java.util.*;

public class Main1_6 { //소수 나열하기
    public static ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 2; i <=n; i++) {
            int count = 0;
            for(int j = 1; j <= i; j++) {
                if(i % j == 0){
                    count++;
                }
            }
            if (count == 2)
                answer.add(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int x : solution(n))
            System.out.print(x+" ");
    }
}
