// class Solution {
//     public int numIdenticalPairs(int[] nums) {
//          int count = 0;
//         int[] frequency = new int[101]; // since 1 <= nums[i] <= 100

//         for (int num : nums) {
//             count += frequency[num];
//             frequency[num]++;
//         }

//         return count;
    
        
//     }
// }

class Solution {

    public int numIdenticalPairs(int[] nums) {
        // Initialize a map to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Initialize the count of good pairs
        int goodPairs = 0;

        // Calculate the number of good pairs
        for (int count : frequencyMap.values()) {
            goodPairs += count * (count - 1) / 2;
        }

        // Return the total number of good pairs
        return goodPairs;
    }
}