class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        // Initialize the result array to store the number of distinct colors after each query
        int[] result = new int[queries.length];
        
        // HashMap to map each ball to its current color
        Map<Integer, Integer> ballToColor = new HashMap<>();
        
        // HashMap to keep track of the frequency of each color
        Map<Integer, Integer> colorCount = new HashMap<>();
        
        // Iterate over each query
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];   // Extract the ball number from the query
            int color = queries[i][1];  // Extract the color number from the query
            
            // Check if the ball has been previously colored
            if (ballToColor.containsKey(ball)) {
                int prevColor = ballToColor.get(ball);  // Get the previous color of the ball
                
                // Decrement the count of the previous color
                colorCount.put(prevColor, colorCount.get(prevColor) - 1);
                
                // If the count of the previous color becomes zero, remove it from the map
                if (colorCount.get(prevColor) == 0) {
                    colorCount.remove(prevColor);
                }
            }
            
            // Assign the new color to the ball
            ballToColor.put(ball, color);
            
            // Increment the count of the new color
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            
            // The number of distinct colors is the size of the colorCount map
            result[i] = colorCount.size();
        }
        
        // Return the result array containing the number of distinct colors after each query
        return result;
    }
}
