package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    Stack<Integer> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    // Stack, Queue, PriorityQueue flags (in order)
    boolean[] flags = {true, true, true};

    int n = Integer.parseInt(cin.nextLine());
    for (int i = 0; i < n; i++) {
      String[] line = cin.nextLine().split(" ");
      if (line[0].equals("1")) {
        put(stack, queue, priorityQueue, Integer.parseInt(line[1]));
      } else {
        take(stack, queue, priorityQueue, Integer.parseInt(line[1]), flags);
      }
    }

    int count = 0;
    for (int i = 0; i < flags.length; i++) {
      if (flags[i]) {
        count++;
      }
    }

    if (count > 1) {
      System.out.println("not sure");
    } else if (count == 0) {
      System.out.println("impossible");
    } else {
      // One is answer
      if (flags[0]) {
        System.out.println("stack");
      } else if (flags[1]) {
        System.out.println("queue");
      } else {
        System.out.println("priority queue");
      }
    }

    cin.close();
  }

  static void put(Stack<Integer> stack, Queue<Integer> queue, PriorityQueue<Integer> priorityQueue,
      int input) {
    stack.push(input);
    queue.add(input);
    priorityQueue.add(input);
  }

  static void take(Stack<Integer> stack, Queue<Integer> queue, PriorityQueue<Integer> priorityQueue,
      int answer, boolean[] flags) {
    if (stack.isEmpty() || queue.isEmpty() || priorityQueue.isEmpty()) {
      flags[0] = false;
      flags[1] = false;
      flags[2] = false;
      return;
    }
    int stackPopped = stack.pop();
    int queuePopped = queue.poll();
    int priorityQueuePopped = priorityQueue.poll();

    if (stackPopped != answer) {
      flags[0] = false;
    }
    if (queuePopped != answer) {
      flags[1] = false;
    }
    if (priorityQueuePopped != answer) {
      flags[2] = false;
    }
  }
}
