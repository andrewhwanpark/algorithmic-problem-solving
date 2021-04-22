// Collaborated with Aadil Mufti on idea

// package p5;

import java.util.*;
import java.math.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(reader.readLine());
    BigInteger[] input = new BigInteger[N];
    int idx = 0;

    String line = reader.readLine();
    StringTokenizer st = new StringTokenizer(line, " ");
    while (st.hasMoreTokens()) {
      input[idx] = new BigInteger(st.nextToken());
      idx++;
    }

    System.out.println(maxNum(input));
  }

  static String maxNum(BigInteger[] nums) {
    String[] strNums = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strNums[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strNums, new Comparator<String>() {
      public int compare(String a, String b) {
        return (b + a).compareTo(a + b);
      }
    });
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < strNums.length; i++) {
      builder.append(strNums[i]);
    }
    return builder.toString();
  }
}
