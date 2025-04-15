import java.util.*;
import java.util.stream.*;

public class ProductSalesAnalysis {
    static class Sale {
        final private String productId;
        final private int quantity;
        final private double price;
        public Sale(String productId, int quantity, double price) {
            this.productId = productId;
            this.quantity = quantity;
            this.price = price;
        }
        public String getProductId() {
            return productId;
        }
        public int getQuantity() {
            return quantity;
        }
        public double getPrice() {
            return price;
        }
    }
    static class ProductSales {
        final private String productId;
        final private double totalRevenue;
        public ProductSales(String productId, double totalRevenue) {
            this.productId = productId;
            this.totalRevenue = totalRevenue;
        }
        public String getProductId() {
            return productId;
        }
        public double getTotalRevenue() {
            return totalRevenue;
        }
        @Override
        public String toString() {
            return productId + " - Total Revenue: $" + String.format("%.2f", totalRevenue);
        }
    }

    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P01", 5, 100.0),
            new Sale("P02", 15, 50.0),
            new Sale("P03", 20, 30.0),
            new Sale("P04", 8, 200.0),
            new Sale("P05", 12, 80.0),
            new Sale("P06", 25, 40.0),
            new Sale("P07", 18, 70.0),
            new Sale("P08", 30, 20.0)
        );
        List<Sale> filteredSales = sales.stream()
            .filter(s -> s.getQuantity() > 10)
            .collect(Collectors.toList());

        List<ProductSales> productSalesList = filteredSales.stream()
            .map(s -> new ProductSales(s.getProductId(), s.getQuantity() * s.getPrice()))
            .collect(Collectors.toList());

        List<ProductSales> sortedByRevenue = productSalesList.stream()
            .sorted(Comparator.comparingDouble(ProductSales::getTotalRevenue).reversed())
            .collect(Collectors.toList());

        List<ProductSales> top5Products = sortedByRevenue.stream()
            .limit(5)
            .collect(Collectors.toList());

        System.out.println("Top 5 Products by Total Revenue:");
        top5Products.forEach(System.out::println);
    }
}
