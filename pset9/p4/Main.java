// Minimum number of coin DP problem:
// https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/

package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int M = cin.nextInt();
    int N = cin.nextInt();
    int[] coins = new int[N];

    for (int i = 0; i < N; i++) {
      coins[i] = cin.nextInt();
    }

    int minOverpay = getMinOverpay(M, coins);
    int minCoins = getMinCoins(M + minOverpay, coins);
    System.out.println(M + minOverpay + " " + minCoins);

    cin.close();
  }

  static int getMinOverpay(int target, int[] coins) {
    int[][] arr = new int[coins.length + 1][target + 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i][0] = 0;
    }
    for (int i = 1; i < arr[0].length; i++) {
      arr[0][i] = Integer.MAX_VALUE;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        if (coins[i - 1] > j) {
          arr[i][j] = Math.min(coins[i - 1] - j, arr[i - 1][j]);
        } else {
          arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j - coins[i - 1]]);
        }
      }
    }
    return arr[coins.length][target];
  }

  static int getMinCoins(int target, int[] coins) {
    int[] arr = new int[target + 1];
    arr[0] = 0;
    for (int i = 1; i < arr.length; i++) {
      arr[i] = Integer.MAX_VALUE;
    }
    for (int i = 1; i < arr.length; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          int subres = arr[i - coins[j]];
          if (subres != Integer.MAX_VALUE && subres + 1 < arr[i]) {
            arr[i] = subres + 1;
          }
        }
      }
    }

    if (arr[target] == Integer.MAX_VALUE) {
      return -1;
    }
    return arr[target];
  }
}
