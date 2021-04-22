// Algorithm from:
// https://github.com/AlexBarnes86/uva-java/blob/master/AOAPC/src/vol1/SortingSearching/Problem120.java

package p2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] line = cin.nextLine().split(" ");
    ArrayList<Integer> input = new ArrayList<>();

    for (int i = 0; i < line.length; i++) {
      input.add(Integer.parseInt(line[i]));
    }

    ArrayList<Integer> flips = pancakeSort(input);
    for (int i = 0; i < flips.size(); i++) {
      System.out.print(flips.get(i) + " ");
    }
    System.out.println("0");
  }

  static void flip(ArrayList<Integer> pancakes, int pos) {
    ArrayList<Integer> copy = new ArrayList(pancakes);
    for (int i = 0; i <= pos; i++) {
      pancakes.set(i, copy.get(pos - i));
    }
  }

  static ArrayList<Integer> pancakeSort(ArrayList<Integer> input) {
    ArrayList<Integer> flips = new ArrayList<>();
    ArrayList<Integer> sorted = new ArrayList(input);
    Collections.sort(sorted);

    for (int i = sorted.size() - 1; i > 0; i--) {
      if (input.get(i) == sorted.get(i)) {
        continue;
      }
      int pos = input.indexOf(sorted.get(i));
      if (pos != 0) {
        flip(input, pos);
        flips.add(input.size() - pos);
      }
      flip(input, i);
      flips.add(input.size() - i);
    }

    return flips;
  }
}
