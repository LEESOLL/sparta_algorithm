package week_3;

import java.util.Stack;

public class Main3_6 { // 신호 송신한 탑 배열 반환하기
    public static int[] solution(Stack<Integer> heights) {
        int[] answer = new int[heights.size()];
        int len = answer.length-1;
        while(heights.size() > 0) {
            int n = heights.size();
            int tmp = heights.pop();
            for(int i = n - 2; i >= 0; i--) {
                if(heights.get(i) > tmp){
                    answer[len--] = i + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Stack<Integer> heights = new Stack<>();
        heights.push(6);
        heights.push(9);
        heights.push(5);
        heights.push(7);
        heights.push(4);

        for(int x : solution(heights))
            System.out.println(x);
    }
}
