package com.stock.stock.Classes;
import jakarta.persistence.*;
import lombok.Data;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(nullable = false, unique = true)
    protected String email;
    protected String name;
    protected String password;
    protected String imgUrl;
    private String type;

    public User() {
    }

    public User(String name, String email, String password, String imgUrl) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.imgUrl = imgUrl;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

}
