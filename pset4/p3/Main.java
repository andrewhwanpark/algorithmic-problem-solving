package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] params = cin.nextLine().split(" ");
    int N = Integer.parseInt(params[0]);
    int T = Integer.parseInt(params[1]);
    int M = Integer.parseInt(params[2]);

    Queue<Integer> left = new LinkedList<>();
    Queue<Integer> right = new LinkedList<>();
    Queue<String> inputOrder = new LinkedList<>();

    for (int i = 0; i < M; i++) {
      String line = cin.nextLine();
      inputOrder.add(line);

      String[] parsedLine = line.split(" ");
      if (parsedLine[1].equals("left")) {
        left.add(Integer.parseInt(parsedLine[0]));
      } else {
        right.add(Integer.parseInt(parsedLine[0]));
      }
    }

    HashMap<String, ArrayList<Integer>> map = calcFerryArrival(left, right, N, T);

    while (!inputOrder.isEmpty()) {
      String input = inputOrder.poll();
      ArrayList<Integer> list = map.get(input);
      System.out.println(list.get(0));
      list.remove(0);
    }

    cin.close();
  }

  static HashMap<String, ArrayList<Integer>> calcFerryArrival(Queue<Integer> left,
      Queue<Integer> right, int N, int T) {
    int time = 0;
    boolean boatLeft = true;

    HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    while (!left.isEmpty() || !right.isEmpty()) {
      ArrayList<String> loaded;

      if (boatLeft) {
        if (goToOtherSide(left, right, time, boatLeft)) {
          time += (time < right.peek()) ? right.peek() - time + T : T;
          boatLeft = !boatLeft;
          loaded = loadCars(right, time, N, boatLeft);
        } else {
          if (time < left.peek()) {
            time += left.peek() - time;
          }
          loaded = loadCars(left, time, N, boatLeft);
        }
        boatLeft = !boatLeft;
        time += T;
        for (int i = 0; i < loaded.size(); i++) {
          if (map.containsKey(loaded.get(i))) {
            ArrayList<Integer> list = map.get(loaded.get(i));
            list.add(time);
          } else {
            map.put(loaded.get(i), new ArrayList<>(Arrays.asList(time)));
          }
        }
      } else {
        if (goToOtherSide(left, right, time, boatLeft)) {
          time += (time < left.peek()) ? left.peek() - time + T : T;
          boatLeft = !boatLeft;
          loaded = loadCars(left, time, N, boatLeft);
        } else {
          if (time < right.peek()) {
            time += right.peek() - time;
          }
          loaded = loadCars(right, time, N, boatLeft);
        }
        boatLeft = !boatLeft;
        time += T;
        for (int i = 0; i < loaded.size(); i++) {
          if (map.containsKey(loaded.get(i))) {
            ArrayList<Integer> list = map.get(loaded.get(i));
            list.add(time);
          } else {
            map.put(loaded.get(i), new ArrayList<>(Arrays.asList(time)));
          }
        }
      }
    }
    return map;
  }

  static ArrayList<String> loadCars(Queue<Integer> queue, int time, int N, boolean boatLeft) {
    ArrayList<String> loaded = new ArrayList<>();
    while (!queue.isEmpty() && queue.peek() <= time && loaded.size() < N) {
      if (boatLeft) {
        loaded.add(String.format("%d left", queue.poll()));
      } else {
        loaded.add(String.format("%d right", queue.poll()));
      }
    }
    return loaded;
  }

  static boolean goToOtherSide(Queue<Integer> left, Queue<Integer> right, int time,
      boolean boatLeft) {
    if (boatLeft) {
      if (left.isEmpty()) {
        return true;
      }
      if (right.isEmpty()) {
        return false;
      }
      int leftDiff = left.peek() - time;
      int rightDiff = right.peek() - time;

      if (leftDiff < 0 && rightDiff < 0) {
        return false;
      }
      if (leftDiff <= rightDiff) {
        return false;
      }
      return true;
    } else {
      if (right.isEmpty()) {
        return true;
      }
      if (left.isEmpty()) {
        return false;
      }
      int leftDiff = left.peek() - time;
      int rightDiff = right.peek() - time;
      if (leftDiff < 0 && rightDiff < 0) {
        return false;
      }
      if (leftDiff >= rightDiff) {
        return false;
      }
      return true;
    }
  }
}
