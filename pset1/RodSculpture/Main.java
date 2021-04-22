package pset1.RodSculpture;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    int L = Integer.parseInt(cin.nextLine());
    String[] dirs = cin.nextLine().split(" ");

    String output = calcDir(dirs, dirs.length);
    System.out.print(output);
  }

  static String calcDir(String[] dirs, int N) {
    if (N == 1) {
      return dirs[0];
    }

    if (N == 2) {
      return calcRelation(dirs[N - 2], dirs[N - 1]);
    }
    return calcRelation(calcDir(dirs, N - 1), dirs[N - 1]);
  }

  static String calcRelation(String first, String second) {
    if (first.equals("No")) {
      if (second.equals("No")) {
        return "+x";
      }
      return second;
    }
    if (first.equals("+x")) {
      if (second.equals("No")) {
        return first;
      }
      return second;
    }
    if (first.equals("-x")) {
      switch (second) {
        case "+y":
          return "-y";
        case "-y":
          return "+y";
        case "+z":
          return "-z";
        case "-z":
          return "+z";
        default:
          return first;
      }
    }
    if (first.equals("+y")) {
      switch (second) {
        case "+y":
          return "-x";
        case "-y":
          return "+x";
        case "+z":
          return "+y";
        case "-z":
          return "+y";
        default:
          return first;
      }
    }
    if (first.equals("-y")) {
      switch (second) {
        case "+y":
          return "+x";
        case "-y":
          return "-x";
        case "+z":
          return "-y";
        case "-z":
          return "-y";
        default:
          return first;
      }
    }
    if (first.equals("+z")) {
      switch (second) {
        case "+y":
          return "+z";
        case "-y":
          return "+z";
        case "+z":
          return "-x";
        case "-z":
          return "+x";
        default:
          return first;
      }
    }
    if (first.equals("-z")) {
      switch (second) {
        case "+y":
          return "-z";
        case "-y":
          return "-z";
        case "+z":
          return "+x";
        case "-z":
          return "-x";
        default:
          return first;
      }
    }
    return "No";
  }
}
