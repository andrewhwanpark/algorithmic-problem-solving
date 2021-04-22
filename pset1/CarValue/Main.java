package pset1.CarValue;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    HashMap<Integer, Float> map = new HashMap<>();

    String[] loan = cin.nextLine().split(" ");

    int duration = Integer.parseInt(loan[0]);
    float downPayment = Float.parseFloat(loan[1]);
    float amount = Float.parseFloat(loan[2]);
    int numOfDep = Integer.parseInt(loan[3]);

    for (int i = 0; i < numOfDep; i++) {
      String[] dep = cin.nextLine().split(" ");
      map.put(Integer.parseInt(dep[0]), Float.parseFloat(dep[1]));
    }

    System.out.println(carValue(duration, downPayment, amount, map));
  }

  static String carValue(int duration, float downPayment, float amount,
      HashMap<Integer, Float> map) {
    float carValue = amount + downPayment;
    float amountOwed = amount;
    float monthlyPayment = amount / duration;

    for (int i = 0; i < duration; i++) {
      if (i == 0) {
        // Initial depreciation
        carValue *= (1 - map.get(0));

        if (amountOwed < carValue) {
          return String.format("%d months", i);
        }

        continue;
      } else {
        // Non-initial depreciation
        float depPercent;
        if (map.containsKey(i)) {
          depPercent = map.get(i);
        } else {
          // Recursively get previous rate (i, map)
          depPercent = getPreviousDepRate(i - 1, map);
        }

        carValue *= (1 - depPercent);
      }

      amountOwed -= monthlyPayment;
      // Check if buyer owes less than car value
      if (amountOwed < carValue) {
        if (i < 2) {
          return String.format("%d month", i);
        } else {
          return String.format("%d months", i);
        }
      }
    }

    return String.format("%d months", duration);
  }

  static float getPreviousDepRate(int i, HashMap<Integer, Float> map) {
    if (map.containsKey(i)) {
      return map.get(i);
    }

    return getPreviousDepRate(i - 1, map);
  }
}
