// package p5;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int[] cols = new int[n];
    for (int i = 0; i < n; i++) {
      cols[i] = cin.nextInt();
    }

    int idealHeight = calculateIdealHeight(cols);
    int result = calculateMoves(calcDiffArr(cols, idealHeight));
    System.out.println("The minimum number of moves is " + result + ".");

    cin.close();
  }

  static int calculateIdealHeight(int[] cols) {
    int total = 0;

    for (int i = 0; i < cols.length; i++) {
      total += cols[i];
    }

    return total / cols.length;
  }

  static int[] calcDiffArr(int[] cols, int idealHeight) {
    int[] diff = new int[cols.length];

    for (int i = 0; i < cols.length; i++) {
      diff[i] = idealHeight - cols[i];
    }

    return diff;
  }

  static int calculateMoves(int[] diff) {
    if (diff.length == 0) {
      return 0;
    }

    int moves = 0;
    for (int i = 0; i < diff.length; i++) {
      if (diff[i] > 0) {
        moves += diff[i];
      }
    }

    return moves;
  }
}
