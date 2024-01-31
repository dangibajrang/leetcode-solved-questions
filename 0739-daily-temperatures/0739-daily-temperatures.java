// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         Stack<Integer> stack = new Stack<>();
//         int n = temperatures.length;
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++) {
//             // Add how many days need to wait
//             while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
//                 int topIdx = stack.pop();
//                 // where topIdx < i to calculate how many days to wait
//                 res[topIdx] = i - topIdx;
//             }
//             stack.add(i);
//         }
//         return res;
//     }
// }

class Solution {
  public int[] dailyTemperatures(int[] temperatures) {
    int[] ans = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>(); // a decreasing stack

    for (int i = 0; i < temperatures.length; ++i) {
      while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        final int index = stack.pop();
        ans[index] = i - index;
      }
      stack.push(i);
    }

    return ans;
  }
}