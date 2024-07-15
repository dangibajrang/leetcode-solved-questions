class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
         int answer = 0;
        double pi = Math.acos(-1.0);
        List<Double> pointAngles = new ArrayList<>();

        // Iterate through all points p to find the required polar angle with respect to location
        for (List<Integer> p : points) {
            if (p.get(0).equals(location.get(0)) && p.get(1).equals(location.get(1))) {
                // These are points with the same location as yours
                answer += 1;
            } else {
                int dx = p.get(0) - location.get(0);
                int dy = p.get(1) - location.get(1);
                double angleRad = Math.atan2(dy, dx); // Gives inverse tangent in radians for a coordinate
                // Convert to degrees
                double angleDeg = angleRad * (180) / pi;
                pointAngles.add(angleDeg);
            }
        }

        Collections.sort(pointAngles);
        // Sorting the angles will make sure that the required count is a contiguous length of angles

        int n = pointAngles.size();
        for (int i = 0; i < n; ++i) {
            pointAngles.add(pointAngles.get(i) + 360);
            // Push the angles again by adding 360 to handle the case of consecutive points being after a complete cycle. Ex - 345 and 14 (if angle >= 29)
        }

        int left = 0;
        int cnt = 0;
        // Now a simple implementation of sliding window of size angle
        for (int right = 0; right < pointAngles.size(); ++right) {
            while (pointAngles.get(right) - pointAngles.get(left) > angle) {
                left++;
            }
            cnt = Math.max(cnt, right - left + 1);
        }

        answer += cnt; // Add this length to the number of overlapping points earlier

        return answer;
    
        
    }
}