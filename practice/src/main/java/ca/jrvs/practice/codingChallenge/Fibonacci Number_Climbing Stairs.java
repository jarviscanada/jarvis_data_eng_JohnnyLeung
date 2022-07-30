package ca.jrvs.practice.codingChallenge;

/* https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-355fabda88ca4b3fb89f3b24c424d3d1 */
class FibonacciNumber_ClimbingStairs {

    /* O(2^n). Each iteration of n is split into two more. */
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else if (n > 1) {
            return fib(n - 1) + fib(n - 2);
        }
        //(n < 0)
        return fib(n + 2) - fib(n + 1);
    }

    /* O(n). Loop through n-sized array once. */
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        else if (n > 1) {
            int[] sol = new int[n + 1];
            sol[0] = 0;
            sol[1] = 1;

            for (int i = 2; i <= n; i++) {
                sol[i] = sol[i - 1] + sol[i - 2];
            }
            return sol[n];
        }
        //(n < 0)
        int[] sol = new int[n * -1 + 2];
        sol[n * -1 + 1] = 1;
        sol[n * -1] = 0;

        for (int i = n * -1 - 1; i >= 0; i--) {
            sol[i] = sol[i + 2] - sol[i + 1];
        }
        return sol[0];
    }
}
