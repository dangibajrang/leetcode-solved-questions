class Solution {
  public int maxDistance(List<List<Integer>> arrays) {
    // Initialize variables to track the maximum distance
    int maxDistance = 0;
    
    // Initialize min and max with the first array's first and last element respectively
    int currentMin = arrays.get(0).get(0);
    int currentMax = arrays.get(0).get(arrays.get(0).size() - 1);

    // Iterate through each array starting from the second one
    for (int i = 1; i < arrays.size(); i++) {
      List<Integer> currentArray = arrays.get(i);

      // Calculate potential distances and update maxDistance
      int firstElement = currentArray.get(0);
      int lastElement = currentArray.get(currentArray.size() - 1);

      // Compare the last element of the current array with the min seen so far
      maxDistance = Math.max(maxDistance, lastElement - currentMin);

      // Compare the first element of the current array with the max seen so far
      maxDistance = Math.max(maxDistance, currentMax - firstElement);

      // Update currentMin and currentMax for the next iteration
      currentMin = Math.min(currentMin, firstElement);
      currentMax = Math.max(currentMax, lastElement);
    }

    return maxDistance;
  }
}
