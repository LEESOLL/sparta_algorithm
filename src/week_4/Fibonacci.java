package week_4;

public class Fibonacci { //재귀함수를 이용한 피보나치 수열
    public int fibo(int n) {
        if(n == 1 || n == 2)
            return 1;
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibo(10));
    }
}
