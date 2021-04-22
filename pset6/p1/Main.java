package p1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] line = cin.nextLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int[] input = new int[n];

    for (int i = 1; i <= n; i++) {
      input[i - 1] = Integer.parseInt(line[i]);
    }

    int[] sorted = countSort(input);

    int medianIdx = n / 2;
    System.out.println(sorted[medianIdx]);

    cin.close();
  }

  static int[] countSort(int[] input) {
    int[] output = new int[input.length];
    int[] count = new int[21];

    for (int i = 0; i < input.length; i++) {
      count[input[i]]++;
    }

    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = input.length - 1; i >= 0; i--) {
      output[count[input[i]] - 1] = input[i];
      count[input[i]]--;
    }

    return output;
  }
}
