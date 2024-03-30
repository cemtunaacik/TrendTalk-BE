package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Post;
import java.util.List;
import java.util.Optional;

public interface IPostService {
    Post createPost(Long userId, Post post);
    List<Post> getPostsByUserId(Long userId);
    List<Post> getAllPosts();
    Post updatePost(Long id, Post post);
    void deletePost(Long id);
    List<Post> getRecentPosts();
    Optional<Post> getPostById(Long id);
}
