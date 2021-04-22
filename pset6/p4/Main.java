// DFS Algo from: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/

package p4;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner cin = new Scanner(System.in);

    int N = cin.nextInt();
    double maxDist = cin.nextDouble();

    double[][] coords = new double[N][2];
    LinkedList<Integer>[] graph = new LinkedList[N];

    for (int i = 0; i < N; i++) {
      coords[i][0] = cin.nextDouble();
      coords[i][1] = cin.nextDouble();
      graph[i] = new LinkedList<>();
    }

    for (int i = 0; i < coords.length; i++) {
      for (int j = i + 1; j < coords.length; j++) {
        double dist = calcDist(coords[i][0], coords[j][0], coords[i][1], coords[j][1]);
        if (dist <= maxDist) {
          graph[i].add(j);
        }
      }
    }

    int count = DFS(graph);
    System.out.print(count);
  }

  static int DFS(LinkedList<Integer>[] graph) {
    int constellations = 0;
    boolean[] visited = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!visited[i]) {
        DFSUtil(graph, i, visited);
        constellations++;
      }
    }
    return constellations;
  }

  static void DFSUtil(LinkedList<Integer>[] graph, int v, boolean[] visited) {
    visited[v] = true;
    Iterator<Integer> i = graph[v].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n]) {
        DFSUtil(graph, n, visited);
      }
    }
  }

  static double calcDist(double x1, double x2, double y1, double y2) {
    return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
  }
}
