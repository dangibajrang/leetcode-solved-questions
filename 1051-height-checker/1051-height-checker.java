import java.util.Arrays;

class Solution {
  public int heightChecker(int[] heights) {
    int ans = 0;
    int[] sortedHeights = Arrays.copyOf(heights, heights.length);
    Arrays.sort(sortedHeights);

    for (int i = 0; i < heights.length; i++) {
      if (heights[i] != sortedHeights[i]) {
        ans++;
      }
    }

    return ans;
  }
}
