package com.example.smartvend;
import com.example.smartvend.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> listAllProducts();
    Optional<Product> getProductById(String id);
    Optional<List<String>> getProductReviewsById(String id);
    boolean addReviewToProduct(String productId, String review);

}
