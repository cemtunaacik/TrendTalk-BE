package com.trendtalk.app.repository.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_gen")
    @SequenceGenerator(name = "post_gen", sequenceName = "post_seq", allocationSize = 1)
    private Long id;

    @Column(name = "image_url", nullable = false)
    private String imageUrl; //image string alınmış bunu fotoğraf alacak biçimde düzelt

    @Column(name = "description", nullable = false, length = 5000)
    private String description;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Bu alanda, eğer comments entity ilişkisi varsa eklenir, yoksa yorumlanabilir.
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
     private Set<Comment> comments;

    // Constructors, getters and setters ...
}
