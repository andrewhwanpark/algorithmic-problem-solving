package pset1.Fib2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    System.out.println(fib(n));
  }

  static long fib(int n) {
    long fibs[] = new long[n + 1];
    fibs[0] = 0;

    if (n > 0) {
      fibs[1] = 0;
    }

    if (n > 1) {
      fibs[2] = 1;

      for (int i = 3; i <= n; i++) {
        fibs[i] = fibs[i - 1] + fibs[i - 2];
      }
    }

    return fibs[n];
  }
}
