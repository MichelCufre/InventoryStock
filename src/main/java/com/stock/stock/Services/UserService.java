package com.stock.stock.Services;
import com.stock.stock.Classes.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.stock.stock.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String email, String password, String imgUrl) {
        // Verificar si el user ya existe por email
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Client with email " + email + " already exists!");
        }

        // Crear y guardar el nuevo user
        User user = new User(name, email, password, imgUrl);
        return userRepository.save(user);
    }

    public  List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

}
