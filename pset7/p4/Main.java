// Disjoint set algo from: https://www.geeksforgeeks.org/disjoint-set-data-structures/
// Dummy node algo from: https://sgc109.tistory.com/116

package p4;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String[] line = cin.nextLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);

    int[] parent = new int[(2 * N) + 1];
    int[] sum = new int[(2 * N) + 1];
    int[] num = new int[(2 * N) + 1];

    for (int i = 1; i <= N; i++) {
      parent[i] = i + N;
      parent[i + N] = parent[i];
      sum[i] = i;
      sum[i + N] = sum[i];
      num[i] = 1;
      num[i + N] = num[i];
    }

    for (int i = 0; i < M; i++) {
      String[] input = cin.nextLine().split(" ");
      int command = Integer.parseInt(input[0]);
      if (command == 1) {
        union(parent, num, sum, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
      } else if (command == 2) {
        move(parent, sum, num, Integer.parseInt(input[1]), Integer.parseInt(input[2]));
      } else {
        int rep = find(parent, Integer.parseInt(input[1]));
        System.out.println(num[rep] + " " + sum[rep]);
      }
    }

    cin.close();
  }

  static int find(int[] parent, int i) {
    return parent[i] == i ? i : find(parent, parent[i]);
  }

  static void move(int[] parent, int[] sum, int[] num, int from, int to) {
    int fromRep = find(parent, from);
    int toRep = find(parent, to);
    num[fromRep]--;
    sum[fromRep] -= from;
    num[toRep]++;
    sum[toRep] += from;
    parent[from] = toRep;
  }

  static void union(int[] parent, int[] num, int[] sum, int i, int j) {
    int irep = find(parent, i);
    int jrep = find(parent, j);
    if (irep == jrep) {
      return;
    }
    parent[irep] = jrep;
    num[jrep] += num[irep];
    sum[jrep] += sum[irep];
  }
}
