package p1;

import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner cin = new Scanner(System.in);

    int N = Integer.parseInt(cin.nextLine());
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = cin.nextInt();
    }
    sortInput(input);
    long res = countCost(input, input[0], 0L);
    System.out.println(res);
    cin.close();
  }

  static void sortInput(int[] input) {
    Arrays.sort(input);
  }

  static int[] makeSubArray(int[] input, int sum, int begin, int end) {
    int[] newArr = new int[end - begin + 1];

    for (int i = begin; i < end; i++) {
      newArr[i - begin] = input[i];
    }
    newArr[newArr.length - 1] = sum;
    return newArr;
  }

  static long countCost(int[] input, int sum, long cost) {
    if (input.length == 1) {
      return input[0];
    }

    sortInput(input);

    for (int i = 1; i < input.length; i++) {
      if (sum > input[i]) {
        int[] subArr = makeSubArray(input, sum, i, input.length);
        return countCost(subArr, input[i], cost);
      } else {
        sum += input[i];
        cost += sum;
      }
    }
    return cost;
  }
}
