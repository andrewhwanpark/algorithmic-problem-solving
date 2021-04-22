package p2;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder str = new StringBuilder();

    int n = Integer.parseInt(reader.readLine());
    int[] input = new int[n];

    String line = reader.readLine();
    StringTokenizer st = new StringTokenizer(line, " ");
    int idx = 0;
    while (st.hasMoreTokens()) {
      input[idx] = Integer.parseInt(st.nextToken());
      idx++;
    }

    int[] sorted = countSort(input);

    for (int i = 0; i < sorted.length; i++) {
      str.append(sorted[i]);
      if (i != sorted.length - 1) {
        str.append(" ");
      }
    }

    writer.write(str.toString() + "\n");
    writer.flush();
  }

  static int[] countSort(int[] input) {
    int[] output = new int[input.length];
    int[] count = new int[101];

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
