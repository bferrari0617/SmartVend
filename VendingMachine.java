import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> products;

    public VendingMachine() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product selectProduct(int productNumber) {
        // Adjusting for 0-based index
        int index = productNumber - 1;
        if (index >= 0 && index < products.size()) {
            return products.get(index);
        }
        System.out.println("Invalid product number.");
        return null;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.println((i + 1) + ". " + product.getName() + " - $" + product.getPrice());
        }
    }
}
