package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;

/* https://www.notion.so/jarvisdev/Count-Primes-89f2b4d4936b475a80d98c82b70f2c9c */
public class CountPrimes {

    /* O(nlogn) The total time spent finding the next prime is equal to the number of times we
     * add one to p, which is at most O(sqrtn). Same with removing multiples. */
    public int sieveOfEratosthenes(int n) {
        n -= 1; // Only want numbers less than n, so subtract 1
        if (n < 2)
            return 0;

        int numPrimes = n - 1;

        boolean[] A = new boolean[n + 1];
        Arrays.fill(A, true);

        for (int i = 2; i <= java.lang.Math.sqrt(n); i++)
            if (A[i])
                for (int j = i * i; j <= n; j += i) {
                    if (!A[j])
                        continue;
                    A[j] = false;
                    numPrimes--;
                }

        return numPrimes;
    }

}
