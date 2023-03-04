import java.util.*;

class Main {
  static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
      ArrayList<ArrayList<Integer>> result = new ArrayList<>();
      getPermutationsHelper(arr, 0, result);
      return result;
  }
  
  private static void getPermutationsHelper(ArrayList<Integer> arr, int i, ArrayList<ArrayList<Integer>> result) {
      if (i == arr.size()) {
          result.add(new ArrayList(arr));
          return;
      }
      
      Set<Integer> used = new HashSet<>();
    
      for (int j = i; j < arr.size(); j++) {
          if (!used.contains(arr.get(j))) {
              used.add(arr.get(j));
              Collections.swap(arr, i, j);
              getPermutationsHelper(arr, i + 1, result);
              Collections.swap(arr, i, j);
          }
      }
  }
  
  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    arr.add(1);
    arr.add(2);
    arr.add(2);
    ArrayList<ArrayList<Integer>> result = get_permutations(arr);
    System.out.print(result);
  }
}