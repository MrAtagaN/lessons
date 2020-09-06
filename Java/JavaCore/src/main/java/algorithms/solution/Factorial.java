package algorithms.solution;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(factorialLoop(5));
    }

    public static int factorial(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }


    public static int factorialLoop(int n) {

        int result = 1;

        for (int i = 1; i <= n; i++ ) {
            result*= i;
        }
        return result;
    }
}
