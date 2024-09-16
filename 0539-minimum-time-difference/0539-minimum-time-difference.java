
class Solution {
    public int findMinDifference(List<String> timePoints) {
        // List to store the time points converted into minutes from midnight
        List<Integer> minutesList = new ArrayList<>();
        
        // Convert each time point from "HH:MM" format to total minutes from midnight
        for (String time : timePoints) {
            // Split the time into hours and minutes using the colon
            String[] parts = time.split(":");
            // Parse the hours
            int hours = Integer.parseInt(parts[0]);
            // Parse the minutes
            int minutes = Integer.parseInt(parts[1]);
            // Convert the time to total minutes from midnight (hours * 60 + minutes)
            int totalMinutes = hours * 60 + minutes;
            // Add the total minutes to the list
            minutesList.add(totalMinutes);
        }
        
        // Sort the list of times in ascending order
        Collections.sort(minutesList);
        
        // Initialize the minimum difference with a large value (maximum possible minutes difference is 1440)
        int minDifference = Integer.MAX_VALUE;
        
        // Loop through the sorted list and compare consecutive times to find the minimum difference
        for (int i = 1; i < minutesList.size(); i++) {
            // Calculate the difference between the current and the previous time point
            int difference = minutesList.get(i) - minutesList.get(i - 1);
            // Update the minimum difference if the current difference is smaller
            minDifference = Math.min(minDifference, difference);
        }
        
        // Calculate the circular difference between the first and last time points (crossing midnight)
        int lastDifference = 1440 - minutesList.get(minutesList.size() - 1) + minutesList.get(0);
        // Update the minimum difference with the circular difference if it is smaller
        minDifference = Math.min(minDifference, lastDifference);
        
        // Return the minimum difference found
        return minDifference;
    }
}
