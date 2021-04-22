package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int n = Integer.parseInt(cin.nextLine());

    while (true) {
      String[] line = cin.nextLine().split(" ");
      int term = Integer.parseInt(line[0]);
      if (term == 0) {
        break;
      }
      // Queue<Integer> input = initializeQueue(n);
      // Queue<Integer> output = initializeOutput(line);
      // Stack<Integer> stack = new Stack<>();
      int[] input = initializeInArr(n);
      int[] output = initializeOutArr(line);

      boolean result = isTrainPossible(input, output, n);
      // boolean result = trainPossible(input, stack, output);
      if (result == true) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    }

    cin.close();
  }

  static int[] initializeOutArr(String[] line) {
    int[] arr = new int[line.length];
    for (int i = 0; i < line.length; i++) {
      arr[i] = Integer.parseInt(line[i]);
    }
    return arr;
  }

  static int[] initializeInArr(int n) {
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }
    return arr;
  }

  static Queue<Integer> initializeOutput(String[] line) {
    Queue<Integer> output = new LinkedList<>();
    for (int i = 0; i < line.length; i++) {
      output.add(Integer.parseInt(line[i]));
    }
    return output;
  }

  static Queue<Integer> initializeQueue(int n) {
    Queue<Integer> input = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      input.add(i);
    }
    return input;
  }

  static boolean trainPossible(Queue<Integer> input, Stack<Integer> stack, Queue<Integer> output) {
    while (!input.isEmpty()) {
      int in = input.poll();
      if (in == output.peek()) {
        output.poll();
        // Check top of stack
        while (!stack.isEmpty() && stack.peek() == output.peek()) {
          stack.pop();
          output.poll();
        }
      } else {
        stack.push(in);
      }
    }

    return stack.isEmpty();
  }

  static boolean isTrainPossible(int[] input, int[] output, int n) {
    int count = 0;
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      stack.push(input[i]);
      while (!stack.isEmpty() && stack.peek() == output[count]) {
        stack.pop();
        count++;
      }
    }

    return stack.isEmpty();
  }
}
