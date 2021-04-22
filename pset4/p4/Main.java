package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] input = cin.nextLine().split(" ");
    long N = Long.parseLong(input[0]);
    long L = Long.parseLong(input[1]);
    long R = Long.parseLong(input[2]);

    long x = findMinX(L, R, N);
    System.out.println(x);

    cin.close();
  }

  static long findMinX(long L, long R, long N) {
    if (L == R) {
      return L;
    }

    long result = 0;

    for (int i = 31; i >= 0; i--) {
      long Lbits = bitsToLoc(L, i);
      long Rbits = bitsToLoc(R, i);

      String bitsToUse = whichBitsCanBeUsed(i, Lbits, Rbits, result);
      long Nbit = bitAtLoc(N, i);

      switch (bitsToUse) {
        case "1 or 0":
          if (Nbit == 0) {
            // can set bit to 1
            result = setBitAtLocToOne(result, i);
          }
          break;
        case "1":
          // Set bit to 1
          result = setBitAtLocToOne(result, i);
          break;
        default:
          break;
      }
    }

    return result;
  }

  static long setBitAtLocToOne(long num, long loc) {
    long temp = 1;
    long mask = temp << loc;
    return (num | mask);
  }

  static long bitAtLoc(long num, long loc) {
    long temp = 1;
    long mask = temp << loc;
    return (num & mask);
  }

  static long bitsToLoc(long num, long loc) {
    long tempMask = 0x80000000;
    long mask = tempMask >> (31 - loc);
    return (num & mask);
  }

  static long constructGreaterResult(long result, long loc) {
    long temp = 1;
    long mask = temp << loc;
    return result | mask;
  }

  static String whichBitsCanBeUsed(long loc, long Lbits, long Rbits, long result) {
    long greaterRes = constructGreaterResult(result, loc);

    if (greaterRes <= Rbits && greaterRes >= Lbits && result <= Rbits && result >= Lbits) {
      return "1 or 0";
    } else if (result < Lbits) {
      return "1";
    }
    return "0";
  }
}
