package com.trendtalk.app.repository.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "saves")
public class Save {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "save_gen")
    @SequenceGenerator(name = "save_gen", sequenceName = "save_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_user_id", nullable = false)
    private User sender;

    // Constructors, getters and setters ...
}
