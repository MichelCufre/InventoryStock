package com.stock.stock.Classes;

import jakarta.persistence.*;
import lombok.Data;


public class DTProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String desc;
    private Double price;
    private String imgUrl;

}
