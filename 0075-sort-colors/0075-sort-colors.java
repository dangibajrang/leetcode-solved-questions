class Solution {
  public void sortColors(int[] nums) {
    int zeroIndex = 0; // Position to place the next 0
    int twoIndex = nums.length - 1; // Position to place the next 2
    int currentIndex = 0; // Current index to check

    while (currentIndex <= twoIndex) {
      if (nums[currentIndex] == 0) {
        swap(nums, currentIndex, zeroIndex);
        zeroIndex++;
        currentIndex++;
      } else if (nums[currentIndex] == 2) {
        swap(nums, currentIndex, twoIndex);
        twoIndex--;
      } else {
        currentIndex++;
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
