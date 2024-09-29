class AllOne {
    
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;
        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }
    
    private Map<String, Integer> keyCountMap; // Maps keys to their counts
    private Map<Integer, Node> countNodeMap;  // Maps counts to corresponding nodes in the DLL
    private Node head, tail; // Dummy head and tail nodes for the doubly linked list

    public AllOne() {
        keyCountMap = new HashMap<>();
        countNodeMap = new HashMap<>();
        head = new Node(0); // Dummy head
        tail = new Node(0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    // Increment the count of the key
    public void inc(String key) {
        int count = keyCountMap.getOrDefault(key, 0);
        keyCountMap.put(key, count + 1);
        
        Node currentNode = countNodeMap.get(count);
        Node nextNode = countNodeMap.get(count + 1);
        
        // If there is no node for count + 1, create one
        if (nextNode == null) {
            nextNode = new Node(count + 1);
            countNodeMap.put(count + 1, nextNode);
            if (currentNode == null) {
                addNodeAfter(head, nextNode); // If currentNode is null, add after head
            } else {
                addNodeAfter(currentNode, nextNode); // Otherwise, add after the current node
            }
        }
        
        nextNode.keys.add(key);
        
        if (currentNode != null) {
            currentNode.keys.remove(key);
            if (currentNode.keys.isEmpty()) {
                removeNode(currentNode);
                countNodeMap.remove(count);
            }
        }
    }
    
    // Decrement the count of the key
    public void dec(String key) {
        int count = keyCountMap.getOrDefault(key, 0);
        if (count == 0) return;
        
        keyCountMap.put(key, count - 1);
        Node currentNode = countNodeMap.get(count);
        Node prevNode = countNodeMap.get(count - 1);
        
        if (count - 1 > 0) {
            if (prevNode == null) {
                prevNode = new Node(count - 1);
                countNodeMap.put(count - 1, prevNode);
                addNodeAfter(currentNode.prev, prevNode);
            }
            prevNode.keys.add(key);
        }
        
        currentNode.keys.remove(key);
        if (currentNode.keys.isEmpty()) {
            removeNode(currentNode);
            countNodeMap.remove(count);
        }
        
        if (count - 1 == 0) {
            keyCountMap.remove(key);
        }
    }
    
    // Get one of the keys with the maximum count
    public String getMaxKey() {
        if (tail.prev == head) return ""; // No valid keys
        return tail.prev.keys.iterator().next();
    }
    
    // Get one of the keys with the minimum count
    public String getMinKey() {
        if (head.next == tail) return ""; // No valid keys
        return head.next.keys.iterator().next();
    }
    
    // Helper method to remove a node from the doubly linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    // Helper method to add a node after a given node
    private void addNodeAfter(Node prevNode, Node newNode) {
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
    }
}
