// class Solution {
//     public boolean isPowerOfThree(int n) {
        
//         while(n>=3){
//             if(n%3 != 0) return false;
//             n = n/3;
//         }
//         return  n==1;
        
//     }
// }

class Solution {
    public boolean isPowerOfThree(int n) {
         if(n==1) return true;
        if(n%3!=0 || n==0) return false;
        return isPowerOfThree(n/3);
    }
}