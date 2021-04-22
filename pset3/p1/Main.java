package p1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int m = Integer.parseInt(cin.nextLine());
    int n = Integer.parseInt(cin.nextLine());

    int[] strikes = new int[n];
    for (int i = 0; i < n; i++) {
      strikes[i] = Integer.parseInt(cin.nextLine());
    }

    int result = calcStrikes(m, strikes);
    System.out.println(result);

    cin.close();
  }

  static int calcStrikes(int m, int[] strikes) {
    int count = 0;
    for (int i = 1; i <= m; i++) {
      boolean divides = false;
      for (int j = 0; j < strikes.length; j++) {
        if (i % strikes[j] == 0) {
          divides = true;
        }
      }

      if (divides == true) {
        // Check fri, sat
        if ((i - 6) % 7 != 0 && i % 7 != 0) {
          count++;
        }
      }
    }

    return count;
  }
}
