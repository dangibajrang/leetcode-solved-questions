// class Solution {
//     public boolean isValid(String s) {
//         // Create a stack to keep track of opening parentheses
//         Stack<Character> stack = new Stack<>();
        
//         // Traverse each character in the string
//         for (char c : s.toCharArray()) {
//             // If the character is an opening bracket, push it onto the stack
//             if (c == '(' || c == '{' || c == '[') {
//                 stack.push(c);
//             } 
//             // If the character is a closing bracket
//             else {
//                 // Check if the stack is empty or the top of the stack does not match
//                 if (stack.isEmpty() || !isValidPair(stack.pop(), c)) {
//                     return false;
//                 }
//             }
//         }
//         // If the stack is empty, all brackets are matched correctly
//         return stack.isEmpty();
//     }
    
//     // Helper method to check if the pair of brackets is valid
//     private boolean isValidPair(char open, char close) {
//         return (open == '(' && close == ')') ||
//                (open == '{' && close == '}') ||
//                (open == '[' && close == ']');
//     }
// }




class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}

