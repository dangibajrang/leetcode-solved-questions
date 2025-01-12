// class Solution {
//     public int[] vowelStrings(String[] words, int[][] queries) {
//         int n  =  words.length;
//         int prefixSum[] = new int[n];
//         prefixSum[0] = isVowel(words[0]);

//         for(int i = 0;  i<n; i++){
//            prefixSum[i] =prefixSum[i-1]+ isVowel(words[i]); 
//         }

//         int  m  =queries.length;
//         int ans [] = new int[m];
//         for(int i = 0 ; i < m ; i++){
//             int l  =queries[i][0];
//             int r = queries [i][1];
//             int res =prefixSum[r];
//             if(l != 0){
//                 res-=prefixSum[l-1];
//             }
//             ans[i] =res;

//         }
        
//     }
//     public int isVowel(String word){
//         HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));

//         char first = word.charAt(0);
//         char last = word.charAt(word.length()-1);

//         if(set.contains(first) && set.contains(last)){
//             return 1;

//         }
//         return 0;
//     }
// }

 class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        // Initialize a helper method to check if a character is a vowel.
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        // Create a prefix sum array to store the cumulative count of valid strings.
        int n = words.length;
        int[] prefixSum = new int[n + 1]; // Prefix array of size n+1 for ease of computation.

        // Populate the prefix sum array.
        for (int i = 0; i < n; i++) {
            // Check if the word starts and ends with a vowel.
            if (isVowel(words[i].charAt(0), vowels) && isVowel(words[i].charAt(words[i].length() - 1), vowels)) {
                prefixSum[i + 1] = prefixSum[i] + 1; // Increment the prefix sum if the condition is true.
            } else {
                prefixSum[i + 1] = prefixSum[i]; // Carry forward the previous sum if condition is false.
            }
        }

        // Prepare the result array for the queries.
        int[] result = new int[queries.length];

        // Process each query to calculate the count using prefix sum.
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            // Use the prefix sum to get the count of valid strings in the range [l, r].
            result[i] = prefixSum[r + 1] - prefixSum[l];
        }

        // Return the result array with counts for each query.
        return result;
    }

    // Helper method to check if a character is a vowel.
    private boolean isVowel(char c, Set<Character> vowels) {
        return vowels.contains(c);
    }

}
