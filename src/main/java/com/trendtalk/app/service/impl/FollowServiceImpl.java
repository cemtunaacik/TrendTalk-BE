package com.trendtalk.app.service.impl;

import com.trendtalk.app.repository.entity.Follow;
import com.trendtalk.app.repository.entity.User;
import com.trendtalk.app.repository.interfaces.IFollow;
import com.trendtalk.app.repository.interfaces.IUser;
import com.trendtalk.app.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FollowServiceImpl implements IFollowService {

    private final IFollow followRepository;
    private final IUser userRepository;

    @Autowired
    public FollowServiceImpl(IFollow followRepository, IUser userRepository) {
        this.followRepository = followRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void followUser(Long followerId, Long followingId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower user not found with id: " + followerId));
        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following user not found with id: " + followingId));

        if (followRepository.findByFollowerAndFollowing(follower, following).isEmpty()) {
            Follow follow = new Follow();
            follow.setFollower(follower);
            follow.setFollowing(following);
            followRepository.save(follow);
        }
    }

    @Override
    public void unfollowUser(Long followerId, Long followingId) {
        User follower = userRepository.findById(followerId)
                .orElseThrow(() -> new RuntimeException("Follower user not found with id: " + followerId));
        User following = userRepository.findById(followingId)
                .orElseThrow(() -> new RuntimeException("Following user not found with id: " + followingId));

        List<Follow> followList = followRepository.findByFollowerAndFollowing(follower, following);
        if (!followList.isEmpty()) {
            followRepository.deleteAll(followList); // Tüm ilişkileri sil
        }
    }

    @Override
    public List<User> getFollowers(Long userId) {
        return followRepository.findByFollowing(userRepository.findById(userId).orElseThrow(
                        () -> new RuntimeException("User not found with id: " + userId)))
                .stream()
                .map(Follow::getFollower)
                .collect(Collectors.toList());
    }

    @Override
    public List<User> getFollowing(Long userId) {
        return followRepository.findByFollower(userRepository.findById(userId).orElseThrow(
                        () -> new RuntimeException("User not found with id: " + userId)))
                .stream()
                .map(Follow::getFollowing)
                .collect(Collectors.toList());
    }
}
