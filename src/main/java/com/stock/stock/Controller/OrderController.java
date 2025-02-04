package com.stock.stock.Controller;

import com.stock.stock.Classes.Order;
import com.stock.stock.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/register")
    public ResponseEntity<Order> registerOrder(@RequestBody Order order) {
        Order newOrder = orderService.createOrder(order.getProductList(), order.getUserName())
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }


}
