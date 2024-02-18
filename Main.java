import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        // Corrected the instantiation of Snack objects
        vendingMachine.addProduct(new Snack("Chips", "S001", 1.25f, "200 calories"));
        vendingMachine.addProduct(new Snack("Chocolate Bar", "S002", 1.50f, "250 calories"));

        System.out.println("Welcome to SmartVend Vending Machine");
        vendingMachine.displayProducts();

        System.out.println("Select a product by number:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Product selectedProduct = vendingMachine.selectProduct(choice);

        if (selectedProduct != null) {
            // Check if the product is an instance of Snack to access getNutritionalInfo
            if (selectedProduct instanceof Snack) {
                Snack selectedSnack = (Snack) selectedProduct;
                System.out.println("Nutritional Info: " + selectedSnack.getNutritionalInfo());
            }
            System.out.println("Reviews: " + selectedProduct.getReviews());
            System.out.println("Price: $" + selectedProduct.getPrice());
            System.out.println("Do you want to purchase this product? (yes/no)");
            String purchaseChoice = scanner.next();
            if (purchaseChoice.equalsIgnoreCase("yes")) {
                System.out.println("Product purchased successfully!");
            } else {
                System.out.println("Purchase cancelled.");
            }
        }
    }
}
