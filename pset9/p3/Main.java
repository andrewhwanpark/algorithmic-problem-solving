package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int N = cin.nextInt();
    int M = cin.nextInt();
    Queue<Node> queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      int priority = cin.nextInt();
      boolean myJob = i == M;
      Node node = new Node(priority, myJob);
      queue.add(node);
    }

    int res = handleQueue(queue);
    System.out.println(res);
    cin.close();
  }

  static int getMaxPriorityInQueue(Queue<Node> queue) {
    int maxPriority = Integer.MIN_VALUE;
    Iterator<Node> itr = queue.iterator();
    while (itr.hasNext()) {
      Node currNode = itr.next();
      int currPriority = currNode.getPriority();
      maxPriority = Math.max(maxPriority, currPriority);
    }
    return maxPriority;
  }

  static int handleQueue(Queue<Node> queue) {
    int time = 0;
    boolean done = false;

    while (!done) {
      Node firstNode = queue.poll();
      if (firstNode.getPriority() < getMaxPriorityInQueue(queue)) {
        queue.add(firstNode);
      } else {
        // Print
        time++;
        if (firstNode.getMyJob()) {
          done = true;
        }
      }
    }

    return time;
  }

  static class Node {
    int priority;
    boolean myJob;

    Node(int priority, boolean myJob) {
      this.priority = priority;
      this.myJob = myJob;
    }

    int getPriority() {
      return priority;
    }

    boolean getMyJob() {
      return myJob;
    }
  }
}
