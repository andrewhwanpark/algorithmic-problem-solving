// package p5;

// Used segmented sieve of eratosthenes algorithmn from
// GeeksForGeeks
// https://www.geeksforgeeks.org/segmented-sieve/

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] input = cin.nextLine().split(" ");

    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);

    boolean[] isPrime = segmentedSieve(a, b);
    int[] gaps = findGaps(isPrime, a, b);

    for (int i = 0; i < gaps.length; i++) {
      if (i == gaps.length - 1) {
        System.out.println(gaps[i]);
      } else {
        System.out.print(gaps[i] + " ");
      }
    }

    cin.close();
  }

  static int[] findGaps(boolean[] isPrime, int a, int b) {
    int[] gaps = new int[4];

    int maxGap = Integer.MIN_VALUE;
    int minGap = Integer.MAX_VALUE;

    int prevPrime = -1;
    for (int i = 0; i < isPrime.length; i++) {
      if (isPrime[i]) {
        if (prevPrime == -1) {
          prevPrime = i;
          continue;
        }

        if (i - prevPrime > maxGap) {
          maxGap = i - prevPrime;
          gaps[2] = prevPrime + a;
          gaps[3] = i + a;
        }
        if (i - prevPrime < minGap) {
          minGap = i - prevPrime;
          gaps[0] = prevPrime + a;
          gaps[1] = i + a;
        }

        prevPrime = i;
      }
    }

    if (maxGap == Integer.MIN_VALUE && minGap == Integer.MAX_VALUE) {
      int[] res = {-1};
      return res;
    }

    return gaps;
  }

  static void simpleSieve(int n, ArrayList<Long> primes) {
    boolean[] mark = new boolean[n + 1];

    for (int i = 0; i < mark.length; i++) {
      mark[i] = true;
    }

    for (int p = 2; p * p < n; p++) {
      if (mark[p]) {
        for (int i = p * p; i < n; i += p) {
          mark[i] = false;
        }
      }
    }

    for (long p = 2; p < n; p++) {
      if (mark[(int) p]) {
        primes.add(p);
      }
    }
  }

  static boolean[] segmentedSieve(int a, int b) {
    int limit = (int) Math.floor(Math.sqrt(b));
    ArrayList<Long> primes = new ArrayList<>();
    simpleSieve(limit, primes);

    boolean[] isPrime = new boolean[b - a + 1];
    for (int i = 0; i < isPrime.length; i++) {
      isPrime[i] = true;
    }
    for (int i = 0; i < primes.size(); i++) {
      for (long j = Math.max(primes.get(i) * primes.get(i),
          ((a + primes.get(i) - 1) / primes.get(i) * primes.get(i))); j <= b; j += primes.get(i)) {
        long atemp = a;
        long idxDiff = j - atemp;
        int idx = (int) idxDiff;
        isPrime[idx] = false;
      }
    }

    if (a == 1) {
      isPrime[0] = false;
    }

    return isPrime;
  }
}
