public class Cart {
    // Final ID fixed when created
    private final String cartId;
    // Private array to store item prices internally
    private final double[] prices;
    // Counter to track the number of items added so far
    private int count;

    // Constructor sets fixed cart ID and maximum capacity
    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.count = 0;
    }

    // Adds an item's price if maximum capacity has not been reached
    public void addItem(double price) {
        if (count < prices.length) {
            prices[count] = price;
            count++;
        }
    }

    // Computes and returns the total sum of all item prices on request
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    // Returns the read-only count of items added
    public int getItemCount() {
        return this.count;
    }

    // Getter for fixed cart ID
    public String getCartId() {
        return this.cartId;
    }

    // Main method demonstrating sample input/output and behavior
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        // Add prices: 250, 99, 151
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        // Expected output: 500.0
        System.out.println("cart.getTotal() -> " + cart.getTotal());

        // Expected output: 3
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}