package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    String[] input = cin.nextLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);

    BitSet bitSet = new BitSet();
    int[][] oneTime = new int[N][2];
    int[][] repeating = new int[M][3];

    for (int i = 0; i < N; i++) {
      String[] line = cin.nextLine().split(" ");
      oneTime[i][0] = Integer.parseInt(line[0]);
      oneTime[i][1] = Integer.parseInt(line[1]);
    }

    for (int i = 0; i < M; i++) {
      String[] line = cin.nextLine().split(" ");
      repeating[i][0] = Integer.parseInt(line[0]);
      repeating[i][1] = Integer.parseInt(line[1]);
      repeating[i][2] = Integer.parseInt(line[2]);
    }

    boolean conflict = findConflict(bitSet, oneTime, repeating);

    if (conflict == true) {
      System.out.println("CONFLICT");
    } else {
      System.out.println("NO CONFLICT");
    }

    cin.close();
  }

  static boolean checkInterval(BitSet bitSet, int start, int end) {
    for (int i = start; i < end; i++) {
      if (bitSet.get(i) == true && i <= 1000000) {
        return true;
      }
    }
    return false;
  }

  static boolean checkIntervalRepeat(BitSet bitSet, int start, int end, int interval) {
    int diff = end - start;
    for (int i = 0; i <= 1000000; i += interval) {
      if (checkInterval(bitSet, i + start, i + start + diff) == true) {
        return true;
      }
      bitSet.set(i + start, i + start + diff);
    }
    return false;
  }

  static boolean findConflict(BitSet bitSet, int[][] oneTime, int[][] repeating) {
    // populate one time tasks and check conflict
    for (int i = 0; i < oneTime.length; i++) {
      if (checkInterval(bitSet, oneTime[i][0], oneTime[i][1]) == true) {
        return true;
      }
      bitSet.set(oneTime[i][0], oneTime[i][1]);
    }

    // int lcm = 1;
    // if (repeating.length > 0) {
    // lcm = findLcm(repeating);
    // }

    // populate repeating tasks and check conflict
    for (int i = 0; i < repeating.length; i++) {
      if (checkIntervalRepeat(bitSet, repeating[i][0], repeating[i][1], repeating[i][2]) == true) {
        return true;
      }
    }

    return false;
  }


}
