
// class Solution {
//   public String firstPalindrome(String[] words) {
//     for (final String word : words)
//       if (isPalindrome(word))
//         return word;
//     return "";
//   }

//   private boolean isPalindrome(final String s) {
//     int i = 0;
//     int j = 0;
//     while (i < j)
//       if (s.charAt(i++) != s.charAt(j--))
//         return false;
//     return true;
//   }
    
// }


class Solution {
    public String firstPalindrome(String[] words) {
    for(int i=0; i<words.length; i++)
    {
        String s="";
        int n=words[i].length()-1;
        for(int j=n; j>=0; j--)
        {
            s+=words[i].charAt(j);
        }
        if(s.equals(words[i]))
        {
            return s;
        }
    }
        return "";
    }
}

