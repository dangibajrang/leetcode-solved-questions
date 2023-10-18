//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int n, List<List<Integer>> adj) {

        // Your code here
         List<Integer> list = new ArrayList<>();
        int vis[] = new int[n];
        for(int i=0; i<n; i++){
            if(dfs(adj,i,vis)) list.add(i);
        }
        return list;
    }
    
    boolean dfs(List<List<Integer>> adj, int i, int[] vis){
        if(vis[i]==1) return false;
        if(vis[i]==2) return true;
        
        vis[i] = 1;
        for(int nbrs : adj.get(i)){
            int a = vis[nbrs];
            if(a==1) return false;
            if(a==2) continue;
            if(!dfs(adj,nbrs,vis)) return false;
        }
        vis[i] = 2;
        return true;
    }
}
