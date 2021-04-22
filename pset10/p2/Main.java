package p2;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] line = reader.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);

    int[][] map = new int[n][m];

    for (int i = 0; i < n; i++) {
      String inline = reader.readLine();
      StringTokenizer st = new StringTokenizer(inline, " ");

      int j = 0;
      while (st.hasMoreTokens()) {
        map[i][j] = Integer.parseInt(st.nextToken());
        j++;
      }
    }

    int T = Integer.parseInt(reader.readLine());
    int[] levels = new int[T];

    String tline = reader.readLine();
    StringTokenizer st = new StringTokenizer(tline, " ");
    int idx = 0;
    while (st.hasMoreTokens()) {
      levels[idx] = Integer.parseInt(st.nextToken());
      idx++;
    }

    int[] res = countIslands(map, levels);
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < res.length; i++) {
      if (i == res.length - 1) {
        sb.append(res[i]);
        sb.append("\n");
      } else {
        sb.append(res[i]);
        sb.append(" ");
      }
    }
    writer.write(sb.toString());
    writer.flush();
    reader.close();
  }

  static boolean isSafe(int[][] map, int i, int j, boolean[][] visited, int level) {
    return (i >= 0) && (j >= 0) && (i < map.length) && (j < map[0].length) && (map[i][j] > level)
        && (!visited[i][j]);
  }

  static void BFS(int[][] map, int i, int j, boolean[][] visited, int level) {
    int[] rowAid = {-1, 0, 1, 0};
    int[] colAid = {0, 1, 0, -1};

    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(i, j));
    visited[i][j] = true;

    while (!queue.isEmpty()) {
      Pair cell = queue.peek();
      int newI = cell.i;
      int newJ = cell.j;

      queue.remove();

      for (int idx = 0; idx < 4; idx++) {
        if (isSafe(map, newI + rowAid[idx], newJ + colAid[idx], visited, level)) {
          queue.add(new Pair(newI + rowAid[idx], newJ + colAid[idx]));
          visited[newI + rowAid[idx]][newJ + colAid[idx]] = true;
        }
      }
    }
  }

  static int countIsland(int[][] map, int level) {
    // Count islands
    boolean[][] visited = new boolean[map.length][map[0].length];
    int count = 0;

    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] > level && !visited[i][j]) {
          BFS(map, i, j, visited, level);
          count++;
        }
      }
    }

    return count;
  }

  static int[] countIslands(int[][] map, int[] levels) {
    int[] res = new int[levels.length];
    for (int i = 0; i < levels.length; i++) {
      res[i] = countIsland(map, levels[i]);
    }
    return res;
  }

  static class Pair {
    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }
}

