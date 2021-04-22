package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    HashMap<Integer, Integer> startTimes = new HashMap<>();
    HashMap<Integer, Boolean> isReady = new HashMap<>();
    ArrayList<Queue<Integer>> offices = new ArrayList<>();
    ArrayList<Queue<Integer>> input = new ArrayList<>();

    String[] nAndM = cin.nextLine().split(" ");
    int n = Integer.parseInt(nAndM[0]);
    int m = Integer.parseInt(nAndM[1]);

    for (int i = 0; i < m; i++) {
      Queue<Integer> queue = new LinkedList<>();
      offices.add(queue);
    }

    for (int i = 0; i < n; i++) {
      String[] line = cin.nextLine().split(" ");
      Queue<Integer> queue = new LinkedList<>();
      for (int j = 2; j < 2 + Integer.parseInt(line[1]); j++) {
        queue.add(Integer.parseInt(line[j]));
      }
      input.add(queue);
      startTimes.put(i, Integer.parseInt(line[0]));
      isReady.put(i, true);
    }

    int t = getLastTime(offices, input, startTimes, isReady);
    System.out.println(t);

    cin.close();
  }

  static int getLastTime(ArrayList<Queue<Integer>> offices, ArrayList<Queue<Integer>> input,
      HashMap<Integer, Integer> startTimes, HashMap<Integer, Boolean> isReady) {
    int t = 0;
    boolean inputFinished = false;
    boolean officesFinished = false;

    while (!inputFinished || !officesFinished) {
      for (int i = 0; i < input.size(); i++) {
        if (startTimes.containsKey(i) && startTimes.get(i) == t && isReady.get(i)) {
          int destinationOffice = input.get(i).poll();
          offices.get(destinationOffice - 1).add(i);
          isReady.put(i, false);
          startTimes.remove(i);
        } else if (!startTimes.containsKey(i) && !input.get(i).isEmpty() && isReady.get(i)) {
          int destinationOffice = input.get(i).poll();
          offices.get(destinationOffice - 1).add(i);
          isReady.put(i, false);
        }
      }

      t++;

      // Remove from each office
      for (int i = 0; i < offices.size(); i++) {
        if (!offices.get(i).isEmpty()) {
          int idx = offices.get(i).poll();
          isReady.put(idx, true);
        }
      }

      // Check if done
      for (int i = 0; i < input.size(); i++) {
        if (!input.get(i).isEmpty()) {
          inputFinished = false;
          break;
        }
        inputFinished = true;
      }

      for (int i = 0; i < offices.size(); i++) {
        if (!offices.get(i).isEmpty()) {
          officesFinished = false;
          break;
        }
        officesFinished = true;
      }

    }

    return t;
  }
}
