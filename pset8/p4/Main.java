// Algo from: https://www.redgreencode.com/more-recursive-backtracking-uva-574/
// Implementation detail from:
// https://github.com/Ahmed-ShawkyEgy/UVA/blob/master/574%20-%20Sum%20It%20Up.java

package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int S = cin.nextInt();
    int N = cin.nextInt();

    int[] input = new int[N];
    boolean[] taken = new boolean[N];
    ArrayList<String> results = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      input[i] = cin.nextInt();
    }
    Arrays.sort(input);
    int[] reversed = reverseArray(input);


    dfs(0, S, 0, reversed, taken, results);
    System.out.println("Sums of " + S + ":");
    if (results.size() == 0) {
      System.out.println("NONE");
    } else {
      for (int i = 0; i < results.size(); i++) {
        System.out.println(results.get(i));
      }
    }

    cin.close();
  }

  static int[] reverseArray(int[] input) {
    int[] reversed = new int[input.length];
    for (int i = input.length - 1; i >= 0; i--) {
      reversed[reversed.length - 1 - i] = input[i];
    }
    return reversed;
  }

  static boolean isValid(ArrayList<String> results, String str) {
    for (int i = 0; i < results.size(); i++) {
      if (results.get(i).equals(str)) {
        return false;
      }
    }
    return true;
  }

  static void dfs(int index, int target, int sum, int[] input, boolean[] taken,
      ArrayList<String> results) {
    if (sum == target) {
      boolean first = true;
      String res = "";
      for (int i = 0; i < taken.length; i++) {
        if (taken[i]) {
          if (first) {
            res += input[i];
            first = false;
          } else {
            res += "+" + input[i];
          }
        }
      }

      if (isValid(results, res)) {
        results.add(res);
      }
    }

    if (sum < target) {
      for (int i = index; i < input.length; i++) {
        if (!taken[i] && sum + input[i] <= target) {
          taken[i] = true;
          dfs(i, target, sum + input[i], input, taken, results);
          taken[i] = false;
        }
      }
    }
  }
}
