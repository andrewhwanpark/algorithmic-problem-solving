package recit1;

import java.io.*;
import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = Integer.parseInt(cin.nextLine());

    for (int i = 0; i < n; i++) {
      System.out.println(isBalanced(cin.nextLine()));
    }

    cin.close();
  }

  static String isBalanced(String s) {
    // Initialize stack
    Stack<Character> stack = new Stack<Character>();

    // Iterate over string, add each char to stack
    for (int i = 0; i < s.length(); i++) {
      // If opening brackets, add to stack
      if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
        stack.push(s.charAt(i));
      } else {
        // Pop and compare
        char popped = 'x';
        if (stack.size() > 0) {
          popped = stack.pop();
        } else {
          return "NO";
        }
        switch (s.charAt(i)) {
          case '}':
            if (popped != '{') {
              return "NO";
            }
            break;
          case ']':
            if (popped != '[') {
              return "NO";
            }
            break;
          case ')':
            if (popped != '(') {
              return "NO";
            }
            break;
        }
      }
    }

    // If any remain in stack, return NO
    if (stack.size() == 0) {
      return "YES";
    }
    return "NO";
  }
}
