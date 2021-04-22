package p2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    int n = Integer.parseInt(cin.nextLine());
    int[] input = new int[n];
    String[] line = cin.nextLine().split(" ");

    for (int i = 0; i < line.length; i++) {
      input[i] = Integer.parseInt(line[i]);
    }

    int[] diff = getDiffArr(input);
    int maxDiff = getMaxDiff(diff);
    int minKVal = calcMinKVal(diff, maxDiff);

    System.out.println(minKVal);

    cin.close();
  }

  static int[] getDiffArr(int[] input) {
    int[] diff = new int[input.length];
    diff[0] = input[0];
    for (int i = 0; i < input.length - 1; i++) {
      diff[i + 1] = input[i + 1] - input[i];
    }
    return diff;
  }

  static int getMaxDiff(int[] diff) {
    return Arrays.stream(diff).max().getAsInt();
  }

  static int calcMinKVal(int[] diff, int maxDiff) {
    int minKVal = maxDiff;
    boolean found = false;

    while (!found) {
      int tempK = minKVal;

      for (int i = 0; i < diff.length; i++) {
        if (diff[i] == tempK) {
          tempK--;
        } else if (diff[i] > tempK) {
          minKVal++;
          found = true;
          break;
        }
      }

      if (!found) {
        minKVal--;
      }
    }

    return minKVal;
  }
}
