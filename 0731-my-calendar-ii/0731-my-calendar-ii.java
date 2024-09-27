class MyCalendarTwo {
    List<int[]> calendar; // For single bookings
    List<int[]> overlaps; // For double bookings

    public MyCalendarTwo() {
        calendar = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Check if it overlaps with any double bookings
        for (int[] overlap : overlaps) {
            if (overlap[0] < end && start < overlap[1]) {
                return false;
            }
        }
        // Check for overlaps with single bookings and add to overlaps list if necessary
        for (int[] event : calendar) {
            if (event[0] < end && start < event[1]) {
                overlaps.add(new int[]{Math.max(start, event[0]), Math.min(end, event[1])});
            }
        }
        // Add the event to the calendar
        calendar.add(new int[]{start, end});
        return true;
    }
}


/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */