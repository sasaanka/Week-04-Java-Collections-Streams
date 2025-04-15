import java.util.*;
class ProductCatalog {
    private final Map<String, Double> prices = new HashMap<>();

    public void setPrice(String productId, double price) {
        prices.put(productId, price);
    }
    public Double getPrice(String productId) {
        return prices.get(productId);
    }
}
public class ShoppingCart{
    private final ProductCatalog catalog;
    private final LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    ShoppingCart(ProductCatalog catalog) {
        this.catalog = catalog;
    }
    public void addItem(String productId, int quantity) {
        cart.merge(productId, quantity, Integer::sum);
    }
    public double totalCost() {
        return cart.entrySet().stream()
            .mapToDouble(e -> catalog.getPrice(e.getKey()) * e.getValue())
            .sum();
    }
    public void displayByInsertionOrder() {
        System.out.println("Cart (insertion order):");
        cart.forEach((pid, qty) -> {double price = catalog.getPrice(pid);
        System.out.printf("  %s ×%d @ $%.2f each%n", pid, qty, price);
        });
    }
    public void displayByPrice() {
        TreeMap<Double, List<String>> byPrice = new TreeMap<>();
        for (String pid : cart.keySet()) {
            double price = catalog.getPrice(pid);
            byPrice.computeIfAbsent(price, p -> new ArrayList<>()).add(pid);
        }
        System.out.println("Cart (sorted by price):");
        byPrice.forEach((price, pids) -> {
            for (String pid : pids) {
                System.out.printf("  %s ×%d @ $%.2f each%n", pid, cart.get(pid), price);
            }
        });
    }
        public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        catalog.setPrice("Apple", 0.99);
        catalog.setPrice("Banana", 0.59);
        catalog.setPrice("Cherry", 2.49);
        ShoppingCart cart = new ShoppingCart(catalog);
        cart.addItem("Apple", 3);
        cart.addItem("Banana", 2);
        cart.addItem("Cherry", 5);
        cart.addItem("Banana", 1);  
        cart.displayByInsertionOrder();
        System.out.printf("Total cost: ", cart.totalCost());
        cart.displayByPrice();
    }
}
