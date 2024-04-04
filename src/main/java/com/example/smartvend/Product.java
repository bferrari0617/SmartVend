package com.example.smartvend;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document("products")
public class Product {
    @Field("name")
    private String name;

    @Id
    @Field("item_id") // Use this annotation to map the id field in MongoDB to this field
    private String item_id;

    @Field("price")
    private float price;

    @Field("quantity")
    private int quantity;

    @Field("category")
    private String category;

    @Field("reviews")
    private List<String> reviews;

    public Product(String name, String item_id, float price, int quantity, String category) {
        this.name = name;
        this.item_id = item_id;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.reviews = new ArrayList<>();
    }

    // Getters and setters for new fields

    public String getName() {
        return name;
    }

    public String getId() {
        return item_id;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void addReview(String review) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }

    public List<String> getReviews() {
        return reviews;
    }
}
