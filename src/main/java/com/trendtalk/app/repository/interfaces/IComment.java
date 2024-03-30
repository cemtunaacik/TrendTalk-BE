package com.trendtalk.app.repository.interfaces;

import com.trendtalk.app.repository.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IComment extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(Long postId);
    // Diğer özel sorgularınızı buraya ekleyebilirsiniz.
}
