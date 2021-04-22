package p4;

import java.math.BigInteger;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = cin.nextInt();
    }
    String res = calcMaxProductSubArray(input);
    System.out.println(res);
    cin.close();
  }

  static String calcMaxProductSubArray(int[] input) {
    BigInteger maxUpToNow = new BigInteger("-2147483647");
    BigInteger max = new BigInteger("1");
    BigInteger min = new BigInteger("1");

    for (int i = 0; i < input.length; i++) {
      BigInteger curr = new BigInteger(String.valueOf(input[i]));
      BigInteger tempMin = min;
      min = curr.min(min.multiply(curr).min(max.multiply(curr)));
      max = curr.max(max.multiply(curr).max(tempMin.multiply(curr)));
      maxUpToNow = maxUpToNow.max(max);
    }

    return maxUpToNow.toString();
  }
}
