// class Solution {
//     public int minKBitFlips(int[] A, int K) {
//         int flips = 0;

//         for (int i = 0; i <= A.length - K; i++) {
//             if (A[i] == 0) {
//                 flips++;
//                 for (int j = 0; j < K; j++) {
//                     A[i + j] ^= 1; // Flip the bit
//                 }
//             }
//         }

//         // Check for any remaining 0's in the last unflipped part of the array
//         for (int i = A.length - K + 1; i < A.length; i++) {
//             if (A[i] == 0) return -1;
//         }

//         return flips;
//     }

//     // public static void main(String[] args) {
//     //     MinimumKBitFlips solver = new MinimumKBitFlips();
//     //     int[] A = {0, 1, 0};
//     //     int K = 1;
//     //     System.out.println(solver.minKBitFlips(A, K)); // Output: 2
//     // }
// }

class Solution {

    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        int[] flip = new int[n];
        int flips = 0, flipCount = 0;

        for (int i = 0; i < n; i++) {
            if (i >= K) {
                flipCount ^= flip[i - K];
            }
            if (A[i] == flipCount % 2) {
                if (i + K > n) {
                    return -1;
                }
                flips++;
                flipCount ^= 1;
                flip[i] = 1;
            }
        }

        return flips;
    }
}
