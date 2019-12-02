package algorithms.solution;

public class Fibonacci {


    public static void main(String[] args) {

        System.out.println(fibonacciRecursion(9));
        System.out.println(fibonacciLoop(9));
    }


    public static int fibonacciRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public static int fibonacciLoop (int n) {
        int current = 1;
        int previous = 0;

        for (int i = 2; i < n; i++) {
            current+= previous;
            previous = current - previous;
        }
        return current + previous;
    }
}
