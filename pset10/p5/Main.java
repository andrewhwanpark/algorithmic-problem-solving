package p5;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    int N = cin.nextInt();
    int W = cin.nextInt();
    int[] input = new int[N];
    for (int i = 0; i < N; i++) {
      input[i] = cin.nextInt();
    }

    ArrayList<String> res = calcGroceryOrder(input, 0, 0, 0, 0, W, new ArrayList<String>());
    System.out.println(res.size());
    for (int i = 0; i < res.size(); i++) {
      System.out.println(res.get(i));
    }
    cin.close();
  }

  static ArrayList<String> calcGroceryOrder(int[] input, int boxOne, int boxTwo, int totalItems,
      int idx, int W, ArrayList<String> order) {
    if (idx == input.length || boxOne > W || boxTwo > W
        || (input[idx] + boxOne > W && input[idx] + boxTwo > W)) {
      return order;
    }

    int currItem = input[idx];
    if (boxOne + currItem > W && boxTwo + currItem <= W) {
      // Put in box 2
      totalItems++;
      boxTwo += currItem;
      idx++;
      order.add("2nd");
      return calcGroceryOrder(input, boxOne, boxTwo, totalItems, idx, W,
          (ArrayList<String>) order.clone());
    } else if (boxTwo + currItem > W && boxOne + currItem <= W) {
      // Put in box 1
      totalItems++;
      boxOne += currItem;
      idx++;
      order.add("1st");
      return calcGroceryOrder(input, boxOne, boxTwo, totalItems, idx, W,
          (ArrayList<String>) order.clone());
    } else {
      // Can fit into both, recurse
      if (idx == 0) {
        totalItems++;
        boxOne += currItem;
        idx++;
        order.add("1st");

        return calcGroceryOrder(input, boxOne, boxTwo, totalItems, idx, W,
            (ArrayList<String>) order.clone());
      } else {
        ArrayList<String> orderOne = (ArrayList<String>) order.clone();
        orderOne.add("1st");
        ArrayList<String> resOne = calcGroceryOrder(input, boxOne + currItem, boxTwo,
            totalItems + 1, idx + 1, W, orderOne);

        ArrayList<String> orderTwo = (ArrayList<String>) order.clone();
        orderTwo.add("2nd");
        ArrayList<String> resTwo = calcGroceryOrder(input, boxOne, boxTwo + currItem,
            totalItems + 1, idx + 1, W, orderTwo);

        return resOne.size() > resTwo.size() ? resOne : resTwo;
      }
    }
  }
}
