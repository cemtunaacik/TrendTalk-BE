package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.entity.Like;
import com.trendtalk.app.repository.entity.Post;
import com.trendtalk.app.repository.entity.User;
import com.trendtalk.app.repository.interfaces.ILike;
import com.trendtalk.app.repository.interfaces.IPost;
import com.trendtalk.app.repository.interfaces.IUser;
import com.trendtalk.app.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LikeServiceImpl implements ILikeService {

    private final ILike likeRepository;
    private final IPost postRepository;
    private final IUser userRepository;

    @Autowired
    public LikeServiceImpl(ILike likeRepository, IPost postRepository, IUser userRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Like likePost(Long userId, Long postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + postId));

        // Check if the like already exists
        List<Like> existingLikes = likeRepository.findByPostId(postId).stream()
                .filter(like -> like.getUser().equals(user))
                .collect(Collectors.toList());

        if (existingLikes.isEmpty()) {
            Like like = new Like();
            like.setUser(user);
            like.setPost(post);
            return likeRepository.save(like);
        } else {
            return existingLikes.get(0); // Return the existing like
        }
    }

    @Override
    public void unlikePost(Long userId, Long postId) {
        List<Like> likes = likeRepository.findByPostId(postId).stream()
                .filter(like -> like.getUser().getId().equals(userId))
                .collect(Collectors.toList());

        if (!likes.isEmpty()) {
            likes.forEach(like -> likeRepository.delete(like));
        }
    }

    @Override
    public List<Like> getLikesByPostId(Long postId) {
        return likeRepository.findByPostId(postId);
    }

    @Override
    public List<Like> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId);
    }

}
