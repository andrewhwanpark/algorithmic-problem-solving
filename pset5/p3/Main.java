package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    ArrayList<Queue<Integer>> arrayOfQueues = new ArrayList<>();
    HashMap<Integer, Queue<Integer>> map = new HashMap<>();

    int n = Integer.parseInt(cin.nextLine());
    for (int i = 0; i < n; i++) {
      int k = cin.nextInt();
      Queue<Integer> queue = new LinkedList<>();
      for (int j = 0; j < k; j++) {
        map.put(cin.nextInt(), queue);
      }

      // Consume next line
      if (i == n - 1) {
        cin.nextLine();
      }
    }

    String[] line = cin.nextLine().split(" ");
    while (!line[0].equals("Shutdown")) {
      if (line[0].equals("Push")) {
        push(map, arrayOfQueues, Integer.parseInt(line[1]));
      } else if (line[0].equals("Pop")) {
        int popped = pop(map, arrayOfQueues);
        System.out.println(popped);
      }

      line = cin.nextLine().split(" ");
    }

    cin.close();
  }

  static void push(HashMap<Integer, Queue<Integer>> map, ArrayList<Queue<Integer>> arrayOfQueues,
      int id) {
    Queue<Integer> queue = map.get(id);
    if (queue.isEmpty()) {
      queue.add(id);
      arrayOfQueues.add(queue);
    } else {
      queue.add(id);
    }
  }

  static int pop(HashMap<Integer, Queue<Integer>> map, ArrayList<Queue<Integer>> arrayOfQueues) {
    Queue<Integer> queue = arrayOfQueues.get(0);
    int popped = queue.poll();
    if (queue.isEmpty()) {
      arrayOfQueues.remove(0);
    }
    return popped;
  }
}
