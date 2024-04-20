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
    private String id;

    @Field("price")
    private float price;

    @Field("quantity")
    private int quantity;

    @Field("category")
    private String category;

    @Field("reviews")
    private List<String> reviews;

    public Product(String name, String id, float price, int quantity, String category) {
        this.name = name;
        this.id = id;
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
        return id;
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
