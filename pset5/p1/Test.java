package p1;

public class Test {
  public static void main(String[] args) {
    int[] num = {3, 4, 5};
    for (int i : num) {
      boolean a = true;
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          a = false;
          break;
        }
      }

      if (a == true) {
        for (int x = 0; x < i; x++) {
          System.out.print("*");
        }
      }
    }


  }
}
