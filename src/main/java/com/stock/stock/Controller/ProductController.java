package com.stock.stock.Controller;
import com.stock.stock.Classes.Product;
import com.stock.stock.Classes.User;
import com.stock.stock.Repository.ProductRepository;
import com.stock.stock.Services.ProductService;
import com.stock.stock.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<Product> registerProduct(@RequestBody Product product) {
        Product newProduct = productService.createProduct(product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl(), product.getQuantity());
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(ProductService.getAllProducts());
    }
}
