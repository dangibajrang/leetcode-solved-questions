class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Pop elements from the stack while the current price is greater or equal
        // to the price at the top of the stack.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push the current price and its span onto the stack.
        stack.push(new int[]{price, span});

        return span;
    }

    // public static void main(String[] args) {
    //     StockSpanner stockSpanner = new StockSpanner();
    //     System.out.println(stockSpanner.next(100)); // return 1
    //     System.out.println(stockSpanner.next(80));  // return 1
    //     System.out.println(stockSpanner.next(60));  // return 1
    //     System.out.println(stockSpanner.next(70));  // return 2
    //     System.out.println(stockSpanner.next(60));  // return 1
    //     System.out.println(stockSpanner.next(75));  // return 4
    //     System.out.println(stockSpanner.next(85));  // return 6
    // }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */