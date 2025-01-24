class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // Initialize a HashMap to store the state of each node (safe or unsafe)
        HashMap<Integer, Boolean> map = new HashMap<>();
        // Get the number of nodes in the graph
        int n = graph.length;
        // Initialize the result list to store all eventual safe nodes
        List<Integer> res = new ArrayList<>();
        
        // Iterate through each node in the graph
        for (int i = 0; i < n; i++) {
            // Perform DFS for each node and check if it's eventually safe
            if (dfs(i, graph, map)) {
                res.add(i); // Add the node to the result if it's safe
            }
        }
        // Return the list of eventual safe nodes
        return res;
    }
    
    // DFS function to determine if a node is eventually safe
    public boolean dfs(int node, int[][] graph, HashMap<Integer, Boolean> map) {
        // If the node's state is already determined, return it
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Mark the node as unsafe initially (to detect cycles)
        map.put(node, false);

        // Traverse all the neighbors of the current node
        for (int neighbour : graph[node]) {
            // If any neighbor is not safe, this node is also not safe
            if (!dfs(neighbour, graph, map)) {
                return false;
            }
        }

        // If all neighbors are safe, mark this node as safe
        map.put(node, true);
        return true;
    }
}
