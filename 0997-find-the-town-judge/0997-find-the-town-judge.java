class Solution {
    public int findJudge(int N, int[][] trust) {
        if (N == 1) {
            return 1; // If there's only one person, they are the judge by default
        }

        int[] trustCounts = new int[N + 1];

        for (int[] t : trust) {
            trustCounts[t[0]]--; // person t[0] trusts someone, decrease their trust count
            trustCounts[t[1]]++; // person t[1] is trusted by someone, increase their trust count
        }

        for (int i = 1; i <= N; i++) {
            if (trustCounts[i] == N - 1) { // the judge should be trusted by N-1 people
                return i;
            }
        }

        return -1; // No judge found
    }

//     public static void main(String[] args) {
//         FindTownJudge finder = new FindTownJudge();
//         int[][] trust = { {1, 3}, {2, 3}, {3, 1} };
//         int N = 3;
//         int judge = finder.findJudge(N, trust);
//         if (judge == -1) {
//             System.out.println("No judge found.");
//         } else {
//             System.out.println("The judge is person: " + judge);
//         }
//     }
}
