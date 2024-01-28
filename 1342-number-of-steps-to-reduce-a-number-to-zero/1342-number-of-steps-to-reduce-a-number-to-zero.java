// class Solution {
//     public int numberOfSteps(int num) {
//         if (num == 0)
//       return 0;
//     final int subtractSteps = Integer.bitCount(num);
//     final int divideSteps = 31 - Integer.numberOfLeadingZeros(num);
//     return subtractSteps + divideSteps;
//     }
// }

class Solution {
    public int numberOfSteps(int num) {
        return helper(num,0);
    }
    private int helper(int num, int steps){
        if(num == 0){
            return steps;
        }
        if(num % 2 == 0){
            return helper(num/2 , steps +1);
        }
        return helper(num-1 ,steps +1);
    }
}