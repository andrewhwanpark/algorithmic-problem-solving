package p2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();

    boolean[] prime = createSieve(n);

    int result = countAwesome(n, prime);
    System.out.println(result);

    cin.close();
  }

  static int countAwesome(int n, boolean[] prime) {
    int count = 0;
    for (int i = 11; i <= n; i += 10) {
      if (prime[i] == true) {
        count++;
      }
    }
    return count;
  }

  static boolean[] createSieve(int n) {
    boolean[] prime = new boolean[n + 1];
    for (int i = 0; i < prime.length; i++) {
      prime[i] = true;
    }
    for (int p = 2; p * p <= n; p++) {
      if (prime[p] == true) {
        for (int i = p * p; i <= n; i += p) {
          prime[i] = false;
        }
      }
    }
    return prime;
  }
}
