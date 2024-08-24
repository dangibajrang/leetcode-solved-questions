class MinStack {
    private Stack<Integer> stack = new Stack<>();   // Stack to store all elements
    private Stack<Integer> minStack = new Stack<>();// Stack to store the minimum values

    public void push(int x) {
        stack.push(x);                              // Push the value onto the main stack
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);  // Push onto the min stack if it's empty or the current value is the new minimum
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();  // Pop from the min stack if the popped value is the current minimum
        }
    }

    public int top() {
        return stack.peek();  // Return the top value of the main stack
    }

    public int getMin() {
        return minStack.peek();  // Return the top value of the min stack (the current minimum)
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */