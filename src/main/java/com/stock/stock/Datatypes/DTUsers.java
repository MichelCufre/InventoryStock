package com.stock.stock.Classes;
import jakarta.persistence.*;
import lombok.Data;


public class DTUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private String imgUrl;


}
