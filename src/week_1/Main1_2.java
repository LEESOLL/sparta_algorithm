package week_1;

public class Main1_2 { //최빈값 찾기

    public static char solution(String str) {
        str = str.replace(" ","");
        char answer = ' ';
        int count = 0;
        int[] alpha = new int[26];

        for(int i = 0; i < str.length(); i++) {
            int x = str.charAt(i) - 97;
            alpha[x]++;
            if(alpha[x] > count) {
                count = alpha[x];
                answer = str.charAt(i);
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        String str = "hello my name is sparta";

        System.out.println(solution(str));
    }
}
