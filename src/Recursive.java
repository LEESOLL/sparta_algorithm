public class Recursive { //재귀함수로 팩토리얼 구현하기
    public static void main(String[] args) {
        int n = 4;
        System.out.println(func(n));
    }

    public static int func(int n) {
        if(n == 0)
            return 1;
        return n * func(n-1);
    }
}
