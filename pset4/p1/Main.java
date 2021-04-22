// Used Shunning Yard algo from
// https://brilliant.org/wiki/shunting-yard-algorithm/

package p1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String input = "";
    while (cin.hasNextLine()) {
      String line = cin.nextLine();
      // if (line.equals("0")) {
      // break;
      // }
      input += line;
    }
    char[] infix = input.toCharArray();
    String result = printRPN(infix);
    System.out.println(result);
    cin.close();
  }

  static String printRPN(char[] infix) {
    String answer = "";
    Stack<Character> ops = new Stack<>();

    for (int i = 0; i < infix.length; i++) {
      if (infix[i] == '(') {
        ops.push(infix[i]);
      } else if (infix[i] == ')') {
        while (!ops.isEmpty()) {
          if (ops.peek() == '(') {
            ops.pop();
            break;
          }
          answer += ops.pop();
        }
      } else if (infix[i] == '+' || infix[i] == '-' || infix[i] == '*' || infix[i] == '/') {
        while (!ops.isEmpty() && higherOrEqualPrec(infix[i], ops.peek())) {
          answer += ops.pop();
        }
        ops.push(infix[i]);
      } else {
        answer += infix[i];
      }
    }

    while (!ops.isEmpty()) {
      answer += ops.pop();
    }

    return answer;
  }

  static boolean higherOrEqualPrec(char a, char b) {
    if (b != '+' && b != '-' && b != '*' && b != '/') {
      return false;
    }

    if (a == '*' || a == '/') {
      if (b == '+' || b == '-') {
        return false;
      }
    }
    return true;
  }
}
