package p5;

// Algorithm using two indices inspired by:
// https://stackoverflow.com/questions/35882366/find-the-longest-subarray-with-distinct-integers

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = Integer.parseInt(cin.nextLine());
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = cin.nextInt();
    }
    int max = countMaxUniqueSubarray(input);
    System.out.println(max);
    cin.close();
  }

  static int countMaxUniqueSubarray(int[] array) {
    int count = 1;
    int max = Integer.MIN_VALUE;
    max = Math.max(max, count);

    HashSet<Integer> map = new HashSet<>();
    map.add(array[0]);

    int i = 0, j = 1;
    while (i < array.length - 1 && j < array.length) {
      if (map.contains(array[j])) {
        map.remove(array[i++]);
        count--;
      } else {
        map.add(array[j++]);
        count++;
      }

      max = Math.max(max, count);
    }

    return max;
  }
}
