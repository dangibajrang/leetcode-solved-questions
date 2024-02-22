class Solution {
  public int findJudge(int n, int[][] trust) {
    // Create an array 'count' to keep track of the net trust count for each person.
    // The array has 'n + 1' elements to match the indexing from 1 to n (inclusive).
    int[] count = new int[n + 1];

    // Iterate through the 'trust' array.
    for (int[] t : trust) {
      // For each trust relationship [a, b], decrement trust count for 'a' and increment trust count for 'b'.
      --count[t[0]];
      ++count[t[1]];
    }

    // Iterate through the elements of the 'count' array starting from index 1.
    for (int i = 1; i < n + 1; ++i)
      // Check if the net trust count for a person 'i' is equal to 'n - 1'.
      // If it is, that person is considered a judge, as everyone trusts them, but they trust no one (except themselves).
      if (count[i] == n - 1)
        return i;

    // If no judge is found, return -1.
    return -1;
  }
}
