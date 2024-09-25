// class Solution {

//     public void helper(int[] nums, int ind, List<Integer> curr, List<List<Integer>> res) {
//         if(ind == nums.length) {
//             res.add(new ArrayList<> (curr));
//             return;
//         }

//         //inc
//         curr.add(nums[ind]);
//         helper(nums, ind+1, curr, res);
//         curr.remove(curr.size() - 1);

//         //exc
//         helper(nums, ind+1, curr, res);
//     }

//     public List<List<Integer>> subsets(int[] nums) {
//         List<Integer> curr = new ArrayList<>();
//         List<List<Integer>> res = new ArrayList<>();
//         helper(nums, 0, curr, res);
//         return res;
//     }
// }



class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(result, new ArrayList<>(), nums, 0);
    return result;
}

        private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
            result.add(new ArrayList<>(tempList)); // Add current subset
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(result, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);  // Backtrack
            }
        }

}



