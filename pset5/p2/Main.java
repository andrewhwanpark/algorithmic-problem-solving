package p2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    ArrayList<Integer> input = new ArrayList<>();
    long result = 0;

    Scanner cin = new Scanner(System.in);
    int n = Integer.parseInt(cin.nextLine());
    for (int i = 0; i < n; i++) {
      int k = cin.nextInt();

      for (int j = 0; j < k; j++) {
        input.add(cin.nextInt());
      }
      result += findTotalPrize(input);
    }

    System.out.println(result);
    cin.close();
  }

  static long findTotalPrize(ArrayList<Integer> input) {
    if (input.size() == 0) {
      return 0;
    }

    Collections.sort(input);
    int max = input.get(input.size() - 1);
    input.remove(input.size() - 1);
    int min = input.get(0);
    input.remove(0);

    return max - min;
  }
}
