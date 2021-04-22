package p3;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int N = cin.nextInt();
    int M = cin.nextInt();
    PriorityQueue<Integer> heads = new PriorityQueue<>();
    PriorityQueue<Integer> archers = new PriorityQueue<>();
    for (int i = 0; i < N; i++) {
      heads.add(cin.nextInt());
    }
    for (int i = 0; i < M; i++) {
      archers.add(cin.nextInt());
    }
    int res = calcGold(N, M, heads, archers);
    if (res == -1) {
      System.out.println("Xia is doomed!");
    } else {
      System.out.println(res);
    }
    cin.close();
  }

  static int calcGold(int N, int M, PriorityQueue<Integer> heads, PriorityQueue<Integer> archers) {
    int gold = 0;
    int defeated = 0;

    if (N > M) {
      return -1;
    }
    while (!heads.isEmpty()) {
      int head = heads.poll();
      while (!archers.isEmpty()) {
        int archer = archers.poll();
        if (archer >= head) {
          gold += archer;
          defeated++;
          break;
        }
      }
    }
    return defeated == N ? gold : -1;
  }
}
