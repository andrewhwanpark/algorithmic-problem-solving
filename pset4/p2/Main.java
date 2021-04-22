// Collaborated ideas with Sara Bonardi and Aadil Mufti

package p2;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);

    ArrayList<String> input = new ArrayList<>();

    while (cin.hasNextLine()) {
      String[] oneLineWords = cin.nextLine().split("\\P{Alpha}+");
      // if (oneLineWords[0].equals("q")) {
      // break;
      // }
      for (int i = 0; i < oneLineWords.length; i++) {
        input.add(oneLineWords[i]);
      }
    }

    printWords(input);

    cin.close();
  }

  static void printWords(ArrayList<String> words) {
    TreeSet<String> tree = new TreeSet<>();

    for (int i = 0; i < words.size(); i++) {
      words.set(i, replaceAndLower(words.get(i)));
      if (words.get(i).length() > 0) {
        tree.add(words.get(i));
      }
    }

    while (!tree.isEmpty()) {
      System.out.println(tree.pollFirst());
    }
  }

  static String replaceAndLower(String str) {
    return str.replaceAll("[^A-Za-z]+", "").toLowerCase();
  }
}
