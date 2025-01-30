package com.stock.stock.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.Classes.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmail(String email); // Verifica si existe un usuario con el email dado
    Optional<User> findByEmail(String email);
    void deleteByEmail(String email);
}
