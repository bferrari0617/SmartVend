package com.example.smartvend;

import com.example.smartvend.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.smartvend.ProductRepository;
import com.example.smartvend.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<List<String>> getProductReviewsById(String id) {
        return productRepository.findById(id)
                .map(Product::getReviews);
    }

    @Override
    public boolean addReviewToProduct(String productId, String review) {
        return productRepository.findById(productId).map(product -> {
            product.addReview(review);
            productRepository.save(product);
            return true;
        }).orElse(false);
    }
}
