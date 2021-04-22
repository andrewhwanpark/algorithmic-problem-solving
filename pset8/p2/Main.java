package p2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] line = cin.nextLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int l = Integer.parseInt(line[1]);
    int w = Integer.parseInt(line[2]);

    ArrayList<int[]> input = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int d = cin.nextInt();
      int r = cin.nextInt();
      int[] temp = {d, r};
      input.add(temp);
    }
    ArrayList<double[]> intervals = getIntervals(input, w);
    sortIntervals(intervals);
    calcMinSprinklers(intervals, l, w);
    cin.close();
  }

  static ArrayList<double[]> getIntervals(ArrayList<int[]> input, int w) {
    ArrayList<double[]> intervals = new ArrayList<>();
    for (int i = 0; i < input.size(); i++) {
      double[] temp = new double[2];

      int dist = input.get(i)[0];
      int radius = input.get(i)[1];
      double halfOfSide = Math.sqrt(Math.pow(radius, 2) - (Math.pow(w, 2) / 4));

      temp[0] = dist - halfOfSide < 0 ? 0 : dist - halfOfSide;
      temp[1] = dist + halfOfSide;
      intervals.add(temp);
    }
    return intervals;
  }

  static void sortIntervals(ArrayList<double[]> intervals) {
    Collections.sort(intervals, new Comparator<double[]>() {
      public int compare(double[] a, double[] b) {
        int cmp = Double.compare(a[0], b[0]);
        return cmp == 0 ? Double.compare(a[1], b[1]) : cmp;
      }
    });
  }

  static void calcMinSprinklers(ArrayList<double[]> intervals, int l, int w) {
    double end = 0;
    int index = 0, count = 0;
    while (index < intervals.size() && end < l) {
      boolean found = false;
      double tempEnd = end;
      for (; index < intervals.size(); index++) {
        if (intervals.get(index)[0] <= tempEnd) {
          end = Math.max(end, intervals.get(index)[1]);
          found = true;
        } else {
          break;
        }
      }
      if (found) {
        count++;
      } else {
        break;
      }
    }
    if (end < l) {
      System.out.println(-1);
    } else {
      System.out.println(count);
    }
  }
}
