package com.trendtalk.app.repository.entity;

import jakarta.persistence.*;
import java.net.URL;

@Entity
@Table(name = "look_category")
public class LookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "look_category_gen")
    @SequenceGenerator(name = "look_category_gen", sequenceName = "look_category_seq", allocationSize = 1)
    private Long id;

    @Column(name = "image_url", nullable = true) // Some categories might not have an image.
    private URL imageUrl;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructors, getters and setters ...
}
