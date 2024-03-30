package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.entity.Post;
import com.trendtalk.app.repository.entity.User;
import com.trendtalk.app.repository.interfaces.IPost;
import com.trendtalk.app.repository.interfaces.IUser;
import com.trendtalk.app.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    private final IPost postRepository;
    private final IUser userRepository;

    @Autowired
    public PostServiceImpl(IPost postRepository, IUser userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        post.setUser(user);
        post.setDateTime(LocalDateTime.now()); // Setting the dateTime when creating a new post
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPostsByUserId(Long userId) {
        // Assuming you have this method defined in your IPost repository to fetch posts by user ID.
        return postRepository.findAllPostsByUserId(userId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post updatePost(Long id, Post postDetails) {
        return postRepository.findById(id).map(post -> {
            post.setImageUrl(postDetails.getImageUrl());
            post.setDescription(postDetails.getDescription());
            post.setDateTime(postDetails.getDateTime()); // You can also choose to not update the date, depending on the business logic
            // Update other fields if necessary
            return postRepository.save(post);
        }).orElseThrow(() -> new RuntimeException("Post not found with id " + id));
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<Post> getRecentPosts() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        // Assuming you have this method defined in your IPost repository to fetch recent posts.
        return postRepository.findByDateTimeAfter(sevenDaysAgo);
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

}
