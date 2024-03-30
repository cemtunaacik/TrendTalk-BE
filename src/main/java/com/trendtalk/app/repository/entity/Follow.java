package com.trendtalk.app.repository.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "follows")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_gen")
    @SequenceGenerator(name = "follow_gen", sequenceName = "follow_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", nullable = false)
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id", nullable = false)
    private User following;

    // Constructors, getters and setters ...
}
