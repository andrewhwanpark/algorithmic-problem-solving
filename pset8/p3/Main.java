package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int N = cin.nextInt();
    int M = cin.nextInt();

    BitSet bitSet = new BitSet(N + 1);
    bitSet.set(0);

    for (int i = 0; i < M; i++) {
      int L = cin.nextInt();
      int R = cin.nextInt();
      int[] res = findPals(bitSet, L, R, N);
      String leftPal = res[0] == -1 ? "*" : String.valueOf(res[0]);
      String rightPal = res[1] == -1 ? "*" : String.valueOf(res[1]);
      System.out.println(leftPal + " " + rightPal);
    }

    cin.close();
  }

  static int[] findPals(BitSet bitSet, int L, int R, int N) {
    bitSet.set(L, R + 1);
    int leftPal = bitSet.previousClearBit(L);
    int rightPal = bitSet.nextClearBit(R);

    if (rightPal > N) {
      rightPal = -1;
    }

    return new int[] {leftPal, rightPal};
  }
}
