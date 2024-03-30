package com.trendtalk.app.repository.entity;

import jakarta.persistence.*;
import java.net.URL;

@Entity
@Table(name = "clothes_subcategory")
public class ClothesSubcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clothes_subcategory_gen")
    @SequenceGenerator(name = "clothes_subcategory_gen", sequenceName = "clothes_subcategory_seq", allocationSize = 1)
    private Long id;

    @Column(name = "image_url", nullable = true) // Bazı alt kategorilerin resmi olmayabilir.
    private URL imageUrl;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private ClothesCategory category;

    // Constructors, getters and setters ...
}
