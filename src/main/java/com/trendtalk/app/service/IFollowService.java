package com.trendtalk.app.service;

import com.trendtalk.app.repository.entity.User;
import java.util.List;

public interface IFollowService {
    void followUser(Long followerId, Long followingId);
    void unfollowUser(Long followerId, Long followingId);
    List<User> getFollowers(Long userId);
    List<User> getFollowing(Long userId);
}
