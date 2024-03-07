package com.example.smartvend;

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
        // ASCII Art for Vending Machine
        System.out.println(
            " ____________________________ \n" +
            "|                            |\n" +
            "|          VENDING           |\n" +
            "|            MACHINE         |\n" +
            "|____________________________|\n" +
            "|  [1]   |  [2]   |  [3]   | |\n" +
            "|_______|_______|_______| |\n" +
            "|  [4]   |  [5]   |  [6]   | |\n" +
            "|_______|_______|_______| |\n" +
            "|          [  ] [  ]        |\n" +
            "|         SELECT  CANCEL    |\n" +
            "|____________________________|"
        );

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Available Products:");
        for (int i = 0; i < products.size() && i < 6; i++) { // Limiting display to 6 products for simplicity
            Product product = products.get(i);
            System.out.printf("%d. %s - $%.2f\n", (i + 1), product.getName(), product.getPrice());
        }

        
    }
}
