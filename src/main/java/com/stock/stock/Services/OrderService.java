package com.stock.stock.Services;

import com.stock.stock.Classes.Order;
import com.stock.stock.Classes.Product;
import com.stock.stock.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(List<Product>productList, String userName) {

        Order order = new Order(productList, userName);
        orderRepository.save(order);
        return order;

    }

    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
