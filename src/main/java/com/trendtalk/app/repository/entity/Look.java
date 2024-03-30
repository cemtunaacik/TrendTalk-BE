package com.trendtalk.app.repository.entity;

import jakarta.persistence.*;
import java.net.URL;
import java.util.List;

@Entity
@Table(name = "looks")
public class Look {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "look_gen")
    @SequenceGenerator(name = "look_gen", sequenceName = "look_seq", allocationSize = 1)
    private Long id;

    @Column(name = "image_url", nullable = true) // Some looks might not have an image.
    private URL imageUrl;

    @Column(name = "note")
    private String note;

    @Column(name = "worn_days")
    private Integer wornDays;

    @ManyToMany
    @JoinTable(
            name = "look_clothes",
            joinColumns = @JoinColumn(name = "look_id"),
            inverseJoinColumns = @JoinColumn(name = "clothes_id") //burada sıkıntı var görüşülsün
    )
    private List<Clothes> clothes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ClothesCategory category;

    // Constructors, getters and setters ...
}
