class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }
    
    private int maxConsecutiveChar(String answerKey, int k, char charToMaximize) {
        int left = 0;
        int count = 0;
        int maxLength = 0;
        
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) != charToMaximize) {
                count++;
            }
            
            while (count > k) {
                if (answerKey.charAt(left) != charToMaximize) {
                    count--;
                }
                left++;
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}



