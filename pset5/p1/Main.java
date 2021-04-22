package p1;
// Acknowledgements: solution discussed with Aadil Mufti

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String input = cin.nextLine();
    String result = getRightString(input);
    System.out.print(result);
    cin.close();
  }

  static String getRightString(String input) {
    StringBuilder str = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == '<') {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(input.charAt(i));
      }
    }

    while (!stack.isEmpty()) {
      str.append(stack.pop());
    }

    return str.reverse().toString();
  }
}
