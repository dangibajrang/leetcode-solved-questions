class Solution {
  public boolean uniqueOccurrences(int[] arr) {
    // Create a HashMap to store the count of occurrences of each element in the array.
    Map<Integer, Integer> count = new HashMap<>();

    // Create a HashSet to keep track of unique occurrences.
    Set<Integer> occurrences = new HashSet<>();

    // Iterate through the array 'arr'.
    for (final int a : arr)
      // For each element 'a', use the merge function to update the count in the 'count' map.
      count.merge(a, 1, Integer::sum);

    // Iterate through the values (counts) in the 'count' map.
    for (final int value : count.values())
      // Check if the value is already present in the 'occurrences' set.
      // If it's not present, add it to the set. If it's already present, return false.
      if (!occurrences.add(value))
        return false;

    // If all occurrences are unique, return true.
    return true;
  }
}
