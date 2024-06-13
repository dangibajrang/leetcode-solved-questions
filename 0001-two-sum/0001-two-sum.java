class Solution {
    public int[] twoSum(int[] numbers, int target) {
           int left = 0 , n =numbers.length, right =n-1;
             int[][] numsWithIndices = new int[numbers.length][2];
        for (int i = 0; i < numbers.length; i++) {
            numsWithIndices[i][0] = numbers[i];
            numsWithIndices[i][1] = i;
        }


             Arrays.sort(numsWithIndices, (a, b) -> Integer.compare(a[0], b[0]));
        // while(L<R){
        //     int sum = numbers[L]+numbers[R];
        //     if(sum ==  target){
        //         return new int[] {L, R};

        //     }else if(sum<target){
        //         L++;
        //     }else{
        //         R--;
        //     }
                   
        //  }
             while (left < right) {
            int leftNum = numsWithIndices[left][0];
            int rightNum = numsWithIndices[right][0];
            int currentSum = leftNum + rightNum;

            if (currentSum == target) {
                return new int[] { numsWithIndices[left][1], numsWithIndices[right][1] };
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }

         return new int[] {-1,-1};
        
    }
}