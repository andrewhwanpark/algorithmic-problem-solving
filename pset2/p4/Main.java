package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = cin.nextInt();
    System.out.print(negativeBase(n));
    cin.close();
  }

  static String negativeBase(int n) {
    if (n == 0) {
      return "0";
    }

    Stack<Integer> stack = new Stack<>();

    int quotient = n;
    while (quotient != 0) {
      int remainder = quotient % -2;
      quotient /= -2;
      if (remainder < 0) {
        remainder += 2;
        quotient++;
      }
      stack.push(remainder);
    }

    String res = "";
    while (!stack.isEmpty()) {
      res += Integer.toString(stack.pop());
    }

    return res;
  }
}
