class NumberContainers {
    // HashMap to store the mapping of index to assigned number
    private HashMap<Integer, Integer> idxToNumber;
    
    // HashMap to store the mapping of number to a sorted set of indices
    private HashMap<Integer, TreeSet<Integer>> numberToIdx;

    // Constructor to initialize the data structures
    public NumberContainers() {
        idxToNumber = new HashMap<>();
        numberToIdx = new HashMap<>();
    }
    
    // Function to update the number at a given index
    public void change(int index, int number) {
        // If the index already has a number assigned, remove it from its current number's set
        if (idxToNumber.containsKey(index)) {
            int prevNumber = idxToNumber.get(index);
            numberToIdx.get(prevNumber).remove(index);
            
            // If no more indices exist for the previous number, remove the entry from the map
            if (numberToIdx.get(prevNumber).isEmpty()) {
                numberToIdx.remove(prevNumber);
            }
        }

        // Assign the new number to the index
        idxToNumber.put(index, number);
        
        // If the number is not already in the map, create a new TreeSet to store indices
        numberToIdx.putIfAbsent(number, new TreeSet<>());
        
        // Add the index to the sorted set for the given number
        numberToIdx.get(number).add(index);
    }
    
    // Function to find the smallest index associated with a given number
    public int find(int number) {
        // If the number is not present in the map, return -1
        if (!numberToIdx.containsKey(number)) {
            return -1;
        }
        // Return the smallest index (first element in TreeSet)
        return numberToIdx.get(number).first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as follows:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index, number);
 * int param_2 = obj.find(number);
 */
