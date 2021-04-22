package p1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    String[] perms = {"BCG", "BGC", "CBG", "CGB", "GBC", "GCB"};

    Scanner cin = new Scanner(System.in);
    long[] input = new long[9];
    for (int i = 0; i < input.length; i++) {
      input[i] = cin.nextLong();
    }

    HashMap<String, Long> map = calcMinMovements(input, perms);

    long min = Long.MAX_VALUE;
    String minLabel = "";

    for (int i = 0; i < perms.length; i++) {
      if (map.get(perms[i]) < min) {
        min = map.get(perms[i]);
        minLabel = perms[i];
      }
    }

    System.out.println(minLabel + " " + min);

    cin.close();
  }

  static HashMap<String, Long> calcMinMovements(long[] input, String[] perms) {
    HashMap<String, Long> map = new HashMap<>();

    for (int i = 0; i < perms.length; i++) {
      String perm = perms[i];
      long count = 0;

      switch (perm.charAt(0)) {
        case 'B':
          count += input[3] + input[6];
          break;
        case 'G':
          count += input[4] + input[7];
          break;
        case 'C':
          count += input[5] + input[8];
          break;
      }

      switch (perm.charAt(1)) {
        case 'B':
          count += input[0] + input[6];
          break;
        case 'G':
          count += input[1] + input[7];
          break;
        case 'C':
          count += input[2] + input[8];
          break;
      }

      switch (perm.charAt(2)) {
        case 'B':
          count += input[0] + input[3];
          break;
        case 'G':
          count += input[1] + input[4];
          break;
        case 'C':
          count += input[2] + input[5];
          break;
      }

      map.put(perm, count);
    }

    return map;
  }
}
