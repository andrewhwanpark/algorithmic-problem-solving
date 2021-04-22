package p5;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder str = new StringBuilder();
    int n = Integer.parseInt(reader.readLine());

    int[] disjoint = new int[n + 1];
    for (int i = 0; i < disjoint.length; i++) {
      disjoint[i] = i;
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    while (true) {
      String[] instruct = reader.readLine().split(" ");
      if (instruct[0].equals("E")) {
        int[] latency = {0};
        int command = find(disjoint, Integer.parseInt(instruct[1]), map, latency, 0);
        if (command == Integer.parseInt(instruct[1])) {
          str.append("0\n");
        } else {
          str.append(map.get(Integer.parseInt(instruct[1])) + "\n");
        }
      } else if (instruct[0].equals("I")) {
        union(disjoint, Integer.parseInt(instruct[1]), Integer.parseInt(instruct[2]));
      } else {
        writer.write(str.toString());
        writer.flush();
        break;
      }
    }
  }

  static void union(int[] disjoint, int from, int to) {
    disjoint[from] = to;
  }

  static int find(int[] disjoint, int target, HashMap<Integer, Integer> map, int[] latency,
      int prevLatency) {
    if (disjoint[target] == target) {
      return target;
    } else {
      int distance =
          map.containsKey(target) ? map.get(target) : Math.abs(disjoint[target] - target) % 1000;
      latency[0] += distance;

      int result = find(disjoint, disjoint[target], map, latency, prevLatency + distance);
      map.put(target, latency[0] - prevLatency);
      disjoint[target] = result;
      return result;
    }
  }
}
