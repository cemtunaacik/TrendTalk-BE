package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IPost extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
    List<Post> findAllPostsByUserId(Long userId);

    List<Post> findByDateTimeAfter(LocalDateTime dateTime);
}
