// Twin prime storage inspired from:
// https://github.com/fkshohag/uva-solution/blob/master/10394%20-%20Twin%20Primes.cpp

package p1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int N = cin.nextInt();
    cin.close();
    boolean[] primes = createSieve(20000000);
    int[] twins = createTwinPrimePairs(primes);
    System.out.println("(" + twins[N] + ", " + (twins[N] + 2) + ")");
  }

  static boolean[] createSieve(int n) {
    boolean[] primes = new boolean[n + 1];
    for (int i = 0; i < primes.length; i++) {
      primes[i] = true;
    }
    for (int p = 2; p * p <= n; p++) {
      if (primes[p]) {
        for (int i = p * p; i <= n; i += p) {
          primes[i] = false;
        }
      }
    }
    return primes;
  }

  static int[] createTwinPrimePairs(boolean[] primes) {
    int[] twins = new int[20000010];
    int idx = 1;
    for (int i = 3; i + 2 <= 20000000; i++) {
      if (primes[i] && primes[i + 2]) {
        twins[idx++] = i;
      }
    }
    return twins;
  }
}
