class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        // Convert the time from "HH:MM" format to minutes since midnight
        int start1 = toMinutes(event1[0]);
        int end1 = toMinutes(event1[1]);
        int start2 = toMinutes(event2[0]);
        int end2 = toMinutes(event2[1]);

        // Check if the events overlap
        // No conflict if one event ends before the other starts
        return !(end1 < start2 || end2 < start1);
    }

    // Helper method to convert "HH:MM" to minutes since midnight
    private int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}
