package week_1;

public class Main1_5 { //반복되지 않는 문자 찾기
    public static char solution(String str) {
        char answer = ' ';
        int count = 0;
        char[] c = str.toCharArray();
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c.length; j++) {
                if (c[j] == c[i])
                    count++;
            }
            if (count == 1)
                return c[i];
            else count = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        String str = "abadabac";

        System.out.println(solution(str));
    }
}
