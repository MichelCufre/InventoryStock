package com.stock.stock.Services;
import com.stock.stock.Classes.Product;
import com.stock.stock.Classes.User;
import com.stock.stock.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(String name, String description, Double price, String imgUrl, Integer qty) {
        if (!productRepository.existsByName(name)) {
            Product product = new Product(name, description, price, imgUrl, qty);
            productRepository.save(product);
            return product;
        }
        return null;
    }

    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product updateProduct(Long id, String name, String description, Double price, String imgUrl, Integer qty) {
        Product product = getProductById(id);

        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setImgUrl(imgUrl);
        product.setQuantity(qty);

        productRepository.save(product);
        return product;
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);

        productRepository.delete(product);
    }

    public static List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
