class CustomStack {
    private int[] stack;
    private int maxSize;
    private int size;
    
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        size = 0; // Initially stack is empty
    }
    
    public void push(int x) {
        if (size < maxSize) {
            stack[size] = x;
            size++; // Increase stack size
        }
    }
    
    public int pop() {
        if (size == 0) {
            return -1; // Stack is empty
        }
        size--; // Decrease stack size
        return stack[size]; // Return the top element
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, size); // Increment only the first k elements or the stack size
        for (int i = 0; i < limit; i++) {
            stack[i] += val; // Add val to the bottom k elements
        }
    }
}
