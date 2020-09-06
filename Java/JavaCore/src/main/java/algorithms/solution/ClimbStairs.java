package algorithms.solution;

public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsWithRecursion(1));
        System.out.println(climbStairsWithRecursion(2));
        System.out.println(climbStairsWithRecursion(3));
        System.out.println(climbStairsWithRecursion(4));
        System.out.println(climbStairsWithRecursion(5));

        System.out.println("----------");

        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }


    public static int climbStairsWithRecursion(int n) {
        int oneClinb;
        int twoClimb;
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            oneClinb = climbStairsWithRecursion(n - 1);
            twoClimb = climbStairsWithRecursion(n - 2);
        }
        return oneClinb + twoClimb;
    }

    public static int climbStairs(int n) {
        int result = 1;
        int previos = 0;
        for (int i = 0; i < n; i++) {
            result += previos;
            previos = result - previos;
        }
        return result;
    }
}
