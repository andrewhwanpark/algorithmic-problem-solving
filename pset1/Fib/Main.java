package pset1.Fib;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    System.out.println(fib(n));
  }

  static int fib(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }

    return fib(n - 1) + fib(n - 2);
  }
}
