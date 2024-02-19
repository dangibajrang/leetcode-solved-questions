class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<= 0) return false;
        if((n &(n-1)) ==  0  )return true;
        return false;
        
    }
    
}


// class Solution{
//     public boolean isPowerOfTwo(int n){
//         if(n<1){
//             return false;
//         }else if(n== 1){
//             return true;
//         }else{
//             while(n%2 == 0){
//                 n= n/2;
//             }
//             if(n== 1){
//                 return true;
//             } else{
//                 return false;
//             }
//         }
//     }
// }