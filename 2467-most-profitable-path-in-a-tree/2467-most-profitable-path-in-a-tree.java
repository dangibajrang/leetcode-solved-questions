class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build adjacency list for the tree
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 1: Find Bob's path to 0
        Map<Integer, Integer> bobTime = new HashMap<>();
        findBobPath(bob, -1, 0, bobTime, graph);

        // Step 2: DFS for Alice's maximum profit
        return dfsAlice(0, -1, 0, 0, graph, bobTime, amount);
    }

    // DFS to find Bob's path to 0 and store arrival times
    private boolean findBobPath(int node, int parent, int time, Map<Integer, Integer> bobTime, List<Integer>[] graph) {
        bobTime.put(node, time);
        if (node == 0) return true;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            if (findBobPath(neighbor, node, time + 1, bobTime, graph)) return true;
        }

        bobTime.remove(node);
        return false;
    }

    // DFS for Alice's traversal to maximize profit
    private int dfsAlice(int node, int parent, int time, int profit, List<Integer>[] graph, Map<Integer, Integer> bobTime, int[] amount) {
        if (bobTime.containsKey(node)) {
            int bobArrival = bobTime.get(node);
            if (bobArrival > time) {
                profit += amount[node]; // Alice arrives first, collects full amount
            } else if (bobArrival == time) {
                profit += amount[node] / 2; // They arrive together, collect half
            }
            // If Bob arrives earlier, Alice collects nothing (profit remains unchanged)
        } else {
            profit += amount[node]; // Alice alone
        }

        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : graph[node]) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxProfit = Math.max(maxProfit, dfsAlice(neighbor, node, time + 1, profit, graph, bobTime, amount));
        }

        return isLeaf ? profit : maxProfit;
    }
}
