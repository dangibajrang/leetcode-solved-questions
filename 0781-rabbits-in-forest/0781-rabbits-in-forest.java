class Solution {
    public int numRabbits(int[] answers) {
        // Create a HashMap to count how many rabbits gave each specific answer.
        Map<Integer, Integer> countMap = new HashMap<>();

        // Loop over each rabbit's answer in the input array.
        for (int answer : answers) {
            // Increase the count of rabbits that gave this particular answer.
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        // Initialize totalRabbits to 0 to store the minimum required rabbits.
        int totalRabbits = 0;

        // Iterate through each unique answer and its count in the map.
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int answer = entry.getKey();     // The answer given by a rabbit.
            int count = entry.getValue();    // How many rabbits gave this answer.

            int groupSize = answer + 1;      // Each group can have at most (answer + 1) rabbits.
            
            // Calculate how many groups are needed using ceiling division.
            int numberOfGroups = (count + groupSize - 1) / groupSize;
            
            // Add the total number of rabbits needed for these groups.
            totalRabbits += numberOfGroups * groupSize;
        }

        // Return the minimum number of rabbits required.
        return totalRabbits;
    }

}
