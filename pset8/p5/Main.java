package p5;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    double M = cin.nextDouble();
    int convertedM = (int) ((M + 0.001) * 100);

    int[] coins = {5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
    long[] ways = new long[convertedM + 1];
    ways[0] = 1;
    long res = calcCoins(ways, coins, convertedM);
    System.out.println(String.format("%6.2f%17s", M, String.valueOf(res)));
    cin.close();
  }

  static long calcCoins(long[] ways, int[] coins, int convertedM) {
    for (int i = 0; i < coins.length; i++) {
      for (int j = 1; j < ways.length; j++) {
        if (coins[i] <= j) {
          ways[j] += ways[j - coins[i]];
        }
      }
    }

    return ways[convertedM];
  }
}
