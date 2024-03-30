package com.trendtalk.app.repository.entity;

import jakarta.persistence.*;
import java.net.URL;

@Entity
@Table(name = "clothes")
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clothes_gen")
    @SequenceGenerator(name = "clothes_gen", sequenceName = "clothes_seq", allocationSize = 1)
    private Long id;

    @Column(name = "image_url", nullable = false)
    private URL imageUrl;

    @Column(name = "used_outfit", nullable = false)
    private boolean usedOutfit;

    @Column(name = "worn_days") //days_worn daha uygun olur
    private Integer wornDays;

    @Column(name = "note")
    private String note;

    @Column(name = "color")
    private String color;

    @Column(name = "fabric")
    private String fabric;

    @Column(name = "size")
    private String size;

    @Column(name = "brand")
    private String brand;

    @Column(name = "price")
    private Double price;

    @Column(name = "url")
    private URL url;

    @Column(name = "sub_category_id")
    private Long subCategoryId;

    @Column(name = "category_id")
    private Long categoryId;

    // Constructors, getters and setters ...
}
