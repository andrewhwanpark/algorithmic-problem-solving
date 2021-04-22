// package p5;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String input = cin.nextLine();
    String output = cin.nextLine();

    System.out.println("[");
    if (input.length() == output.length()) {
      stackPuzzle(input, output, "", "");
    }
    System.out.println("]");

    cin.close();
  }

  static void stackPuzzle(String input, String output, String stack, String currPath) {
    if (output.length() == 0) {
      if (input.length() == 0 && stack.length() == 0) {
        System.out.println(currPath.trim());
      }
      return;
    }

    // Push
    if (input.length() != 0) {
      stackPuzzle(input.substring(1), output, input.charAt(0) + stack, currPath + "i ");
    }
    // Pop
    if (stack.length() != 0 && stack.charAt(0) == output.charAt(0)) {
      stackPuzzle(input, output.substring(1), stack.substring(1), currPath + "o ");
    }
  }
}
