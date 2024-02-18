import java.util.*;

public class Product{
    private String name;
    private String id;
    private float price;
    private List<String> reviews;

    public Product(String name, String id, float price) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    public float getPrice() {
        return price;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public List<String> getReviews() {
        return reviews;
    }
}