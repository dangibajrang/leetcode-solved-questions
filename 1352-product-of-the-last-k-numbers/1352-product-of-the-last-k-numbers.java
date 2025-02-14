class ProductOfNumbers {
    // List to store the prefix products
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        // Initialize the prefix product list with a base product of 1
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {
        // If the number is zero, reset the prefix product list
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            // Calculate the new prefix product and add to the list
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {
        // Calculate the product of the last k numbers
        int n = prefixProducts.size();
        // If k numbers are not available (due to zeros resetting the list), return 0
        if (k >= n) return 0;
        // Divide the last prefix product by the prefix product k steps earlier
        return prefixProducts.get(n - 1) / prefixProducts.get(n - 1 - k);
    }

}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */