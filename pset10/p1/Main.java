package p1;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int M = cin.nextInt();
    int F = cin.nextInt();

    PriorityQueue<Integer> boys = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> girls = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < M; i++) {
      boys.add(cin.nextInt());
    }
    for (int i = 0; i < F; i++) {
      girls.add(cin.nextInt());
    }

    matchStudents(M, F, boys, girls);
    cin.close();
  }

  static void matchStudents(int M, int F, PriorityQueue<Integer> boys,
      PriorityQueue<Integer> girls) {
    if (M <= F) {
      System.out.println("0");
    } else {
      int diff = M - F;
      for (int i = 0; i < F; i++) {
        boys.poll();
      }
      int min = 0;
      while (!boys.isEmpty()) {
        min = boys.poll();
      }
      System.out.println(diff + " " + min);
    }
  }
}
