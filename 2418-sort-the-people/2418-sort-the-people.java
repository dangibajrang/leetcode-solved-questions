class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        // Create an array of pairs (height, name)
        Pair[] people = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            people[i] = new Pair(heights[i], names[i]);
        }
        
        // Sort the pairs based on heights in descending order
        Arrays.sort(people, (a, b) -> b.height - a.height);
        
        // Extract the sorted names
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = people[i].name;
        }
        
        return sortedNames;
        
    }
}