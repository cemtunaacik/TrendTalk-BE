package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.Like;
import java.util.List;

public interface ILikeService {
    Like likePost(Long userId, Long postId);
    void unlikePost(Long userId, Long postId);
    List<Like> getLikesByPostId(Long postId);
    List<Like> getLikesByUserId(Long userId);
}
