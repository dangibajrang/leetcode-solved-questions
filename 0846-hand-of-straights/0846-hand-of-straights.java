import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
  public boolean isNStraightHand(int[] hand, int groupSize) {
    if (hand.length % groupSize != 0) {
      return false; // If the total number of cards is not a multiple of groupSize, return false
    }

    // Step 1: Count occurrences of each card
    HashMap<Integer, Integer> countMap = new HashMap<>();
    for (int card : hand) {
      countMap.put(card, countMap.getOrDefault(card, 0) + 1);
    }

    // Step 2: Add all cards to a priority queue (min-heap)
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(countMap.keySet());

    // Step 3: Try to form groups
    while (!minHeap.isEmpty()) {
      int firstCard = minHeap.poll(); // Get the smallest card
      if (countMap.get(firstCard) == 0) {
        continue; // Skip if this card is already used up
      }

      for (int i = 0; i < groupSize; i++) {
        int card = firstCard + i; // Consecutive card
        if (!countMap.containsKey(card) || countMap.get(card) == 0) {
          return false; // If the card is missing or already used up, return false
        }
        countMap.put(card, countMap.get(card) - 1); // Use one card
      }
    }

    return true;
  }

//   public static void main(String[] args) {
//     Solution sol = new Solution();
//     int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
//     int groupSize = 3;
//     System.out.println(sol.isNStraightHand(hand, groupSize)); // Output should be true
//   }
}
