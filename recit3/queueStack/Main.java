import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    int q = cin.nextInt();

    for (int i = 0; i < q; i++) {
      int op = cin.nextInt();
      switch (op) {
        case 1:
          int ele = Integer.parseInt(cin.nextLine().trim());
          enqueue(s1, s2, ele);
          break;
        case 2:
          dequeue(s1, s2);
          break;
        case 3:
          System.out.println(peek(s1, s2));
          break;
      }
    }

    cin.close();
  }

  static void enqueue(Stack<Integer> s1, Stack<Integer> s2, int target) {
    s1.push(target);
  }

  static int dequeue(Stack<Integer> s1, Stack<Integer> s2) {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }

      return s2.pop();
    }

    return s2.pop();
  }

  static int peek(Stack<Integer> s1, Stack<Integer> s2) {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }

      return s2.peek();
    }

    return s2.peek();
  }
}
