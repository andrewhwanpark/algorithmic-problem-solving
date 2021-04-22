package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = Integer.parseInt(cin.nextLine());
    int[][] input = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] line = cin.nextLine().split(" ");
      input[i][0] = Integer.parseInt(line[0]);
      input[i][1] = Integer.parseInt(line[1]);
    }

    quickSort(input, 0, input.length - 1);
    System.out.println(calcTime(input));

    cin.close();
  }

  static void quickSort(int[][] input, int begin, int end) {
    if (begin < end) {
      int partitionIdx = partition(input, begin, end);

      quickSort(input, begin, partitionIdx - 1);
      quickSort(input, partitionIdx + 1, end);
    }
  }

  static int partition(int[][] input, int begin, int end) {
    int pivot = input[end][1];
    int i = begin - 1;

    for (int j = begin; j < end; j++) {
      if (input[j][1] <= pivot) {
        i++;

        int swapTempOne = input[i][1];
        int swapTempTwo = input[i][0];
        input[i][1] = input[j][1];
        input[i][0] = input[j][0];
        input[j][1] = swapTempOne;
        input[j][0] = swapTempTwo;
      }
    }

    int swapTempOne = input[i + 1][1];
    int swapTempTwo = input[i + 1][0];
    input[i + 1][0] = input[end][0];
    input[i + 1][1] = input[end][1];
    input[end][1] = swapTempOne;
    input[end][0] = swapTempTwo;

    return i + 1;
  }

  static int calcTime(int[][] input) {
    int amadeusTime = 0;
    int maxTime = Integer.MIN_VALUE;

    for (int i = input.length - 1; i >= 0; i--) {
      amadeusTime += input[i][0];
      int gradescopeTime = amadeusTime + input[i][1];
      maxTime = Math.max(maxTime, Math.max(amadeusTime, gradescopeTime));
    }

    return maxTime;
  }
}
