
// import java.util.HashMap;

// class Solution {
//     public int numSubarraysWithSum(int[] nums, int goal) {
//         HashMap <Integer , Integer > map = new HashMap<>();
//         map.put(0,1);
//         int sum = 0 ,count = 0;
//         for(int i = 0; i<nums.length ; i++){
//             sum  += nums[i];
//             if(map.containsKey(sum-goal)){
//                 count+= map.get(sum-goal);
//             }
//             map.put(sum,map.getOrDefault(sum , 0) +1);

//         }
//         return count;

        
        
//     }
//     public static void main (String a[]){
//         int [] nums ={1,0,1,0,1};
//         int goal = 2;
//         System.out.println(numSubarrayWithSum(nums,goal));
//     }
// }



class Solution {
  public int numSubarraysWithSum(int[] nums, int goal) { 
    int ans = 0; // Variable to store the final count of subarrays
    int prefix = 0; // Variable to store the prefix sum
    // {prefix: number of occurrence}
    Map<Integer, Integer> count = new HashMap<>(); // HashMap to store prefix sum occurrences

    count.put(0, 1); // Initialize the count map with prefix sum 0 having occurrence 1 (for handling cases where the prefix itself equals the goal)

    for (final int num : nums) { // Iterate through the array
      prefix += num; // Update the prefix sum
      final int key = prefix - goal; // Calculate the difference between the current prefix sum and the goal
      if (count.containsKey(key)) // Check if there exists a prefix sum whose difference with the current prefix sum equals the goal
        ans += count.get(key); // If yes, increment the answer count by the number of occurrences of such prefix sum
      count.merge(prefix, 1, Integer::sum); // Update the count of the current prefix sum in the map
    }

    return ans; // Return the final count of subarrays
  }
}
