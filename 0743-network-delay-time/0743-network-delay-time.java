class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        // Create adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.putIfAbsent(time[0], new ArrayList<>());
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }
        
        // Priority queue to store the node and its distance from the source
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{K, 0});
        
        // Map to store the shortest distance to each node
        Map<Integer, Integer> dist = new HashMap<>();
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            
            if (dist.containsKey(node)) continue;
            dist.put(node, time);
            
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int nextNode = edge[0];
                    int nextTime = edge[1];
                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{nextNode, time + nextTime});
                    }
                }
            }
        }
        
        if (dist.size() != N) return -1;
        int maxTime = 0;
        for (int time : dist.values()) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
     }
    // public static void main(String[] args) {
    //     NetworkDelayTime ndt = new NetworkDelayTime();
    //     int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
    //     int N = 4;
    //     int K = 2;
    //     System.out.println(ndt.networkDelayTime(times, N, K)); // Output: 2
    // }
}
