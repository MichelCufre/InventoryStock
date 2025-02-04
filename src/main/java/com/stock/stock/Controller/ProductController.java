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
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/getQuantity")
    public ResponseEntity<Integer> getQuantity(@RequestBody Product product) {
        Integer quantity = productService.getQty(product.getId());
        if (quantity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
        }
        return ResponseEntity.ok(quantity);
    }

    @PostMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(product.getId(),product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl(), product.getQuantity());
        if (updatedProduct == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(updatedProduct);
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteProduct(@RequestBody Product product) {
        if (product == null || product.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        productService.deleteProduct(product.getId());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
