class MyCircularDeque {
    private int[] deque;  // Array to store deque elements
    private int front;    // Index for the front element
    private int rear;     // Index for the rear element
    private int size;     // Current number of elements in the deque
    private int capacity; // Maximum capacity of the deque

    // Constructor to initialize the deque with given capacity
    public MyCircularDeque(int k) {
        capacity = k;             // Set the capacity
        deque = new int[capacity]; // Initialize the deque array
        front = 0;                 // Initialize the front index
        rear = 0;                  // Initialize the rear index
        size = 0;                  // Initially, the deque is empty
    }

    // Insert an element at the front. Return true if the operation is successful.
    public boolean insertFront(int value) {
        if (isFull()) {            // Check if the deque is full
            return false;          // Cannot insert if full
        }
        // Calculate the new front index in a circular manner
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;      // Insert the value at the front
        size++;                    // Increment the size
        return true;               // Return true for successful insertion
    }

    // Insert an element at the rear. Return true if the operation is successful.
    public boolean insertLast(int value) {
        if (isFull()) {            // Check if the deque is full
            return false;          // Cannot insert if full
        }
        // Insert the value at the rear
        deque[rear] = value;
        // Move the rear index forward in a circular manner
        rear = (rear + 1) % capacity;
        size++;                    // Increment the size
        return true;               // Return true for successful insertion
    }

    // Delete an element from the front. Return true if the operation is successful.
    public boolean deleteFront() {
        if (isEmpty()) {           // Check if the deque is empty
            return false;          // Cannot delete if empty
        }
        // Move the front index forward in a circular manner
        front = (front + 1) % capacity;
        size--;                    // Decrement the size
        return true;               // Return true for successful deletion
    }

    // Delete an element from the rear. Return true if the operation is successful.
    public boolean deleteLast() {
        if (isEmpty()) {           // Check if the deque is empty
            return false;          // Cannot delete if empty
        }
        // Move the rear index backward in a circular manner
        rear = (rear - 1 + capacity) % capacity;
        size--;                    // Decrement the size
        return true;               // Return true for successful deletion
    }

    // Get the front element. Return -1 if the deque is empty.
    public int getFront() {
        if (isEmpty()) {           // Check if the deque is empty
            return -1;             // Return -1 if empty
        }
        return deque[front];       // Return the front element
    }

    // Get the last element. Return -1 if the deque is empty.
    public int getRear() {
        if (isEmpty()) {           // Check if the deque is empty
            return -1;             // Return -1 if empty
        }
        // As rear points to the next available slot, we need to calculate the last valid index
        return deque[(rear - 1 + capacity) % capacity];
    }

    // Check whether the deque is empty or not.
    public boolean isEmpty() {
        return size == 0;          // Return true if size is 0
    }

    // Check whether the deque is full or not.
    public boolean isFull() {
        return size == capacity;   // Return true if size equals the capacity
    }
}



/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */