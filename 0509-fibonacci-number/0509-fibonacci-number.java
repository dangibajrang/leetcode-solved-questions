// class Solution {
//     public int fib(int n) {
//         if (n < 2) return n;
         
//         return fib(n-1)+ fib(n-2);
        
//     }
// }


class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int seclast = 0, last = 1;
        int ans = 0;

        for(int i = 2; i<=n; i++) {
            ans = seclast + last;
            seclast = last;
            last = ans;
        }

        return ans;
    }
}