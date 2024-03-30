package com.trendtalk.app.repository.entity;

import jakarta.persistence.*;
import java.net.URL;

@Entity
@Table(name = "clothes_category")
public class ClothesCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clothes_category_gen")
    @SequenceGenerator(name = "clothes_category_gen", sequenceName = "clothes_category_seq", allocationSize = 1)
    private Long id;

    @Column(name = "image_url", nullable = true) // Bazı kategorilerin resmi olmayabilir.
    private URL imageUrl;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructors, getters and setters ...
}
