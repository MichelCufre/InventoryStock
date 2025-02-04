package com.stock.stock.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.Classes.Order;
public interface OrderRepository extends JpaRepository<Order, Long> {
}
