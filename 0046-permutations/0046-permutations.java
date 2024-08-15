// public class Solution {
//   // The main function to find all permutations
//   public List<List<Integer>> permute(int[] nums) {
//     // Initialize the result list
//     List<List<Integer>> ans = new ArrayList<>();

//     // Start DFS with an array to keep track of used elements
//     dfs(nums, new boolean[nums.length], new ArrayList<>(), ans);
    
//     // Return the final result
//     return ans;
//   }

//   // DFS function to generate permutations
//   private void dfs(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
//     // If the path size equals the length of the array, add the permutation to the result
//     if (path.size() == nums.length) {
//       ans.add(new ArrayList<>(path));
//       return;
//     }

//     // Explore permutations for each unused element in the array
//     for (int i = 0; i < nums.length; ++i) {
//       // Skip already used elements
//       if (used[i])
//         continue;
      
//       // Mark the current element as used
//       used[i] = true;
      
//       // Add the current element to the path
//       path.add(nums[i]);
      
//       // Recursive call to explore further permutations
//       dfs(nums, used, path, ans);
      
//       // Backtrack by removing the last added element and marking it as unused
//       path.remove(path.size() - 1);
//       used[i] = false;
//     }
//   }
// }



public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // This list will store all the permutations
        List<List<Integer>> result = new ArrayList<>();
        
        // Start the recursive backtracking process with an empty path and the result list
        backtrack(nums, new ArrayList<>(), result);
        
        // Return the final list of permutations
        return result;
    }
    
    // Helper method to perform the backtracking
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        // If the current path contains all numbers, a full permutation is formed
        if (current.size() == nums.length) {
            // Add the current permutation to the result list
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Iterate over the input numbers
        for (int num : nums) {
            // Skip the number if it is already in the current permutation path
            if (current.contains(num)) {
                continue; // Move to the next number
            }
            
            // Add the number to the current path
            current.add(num);
            
            // Continue building the permutation recursively
            backtrack(nums, current, result);
            
            // Backtrack: remove the last added number to explore other possibilities
            current.remove(current.size() - 1);
        }
    }
}

