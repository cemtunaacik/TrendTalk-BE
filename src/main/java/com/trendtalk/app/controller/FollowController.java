package com.trendtalk.app.controller;

import com.trendtalk.app.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follows")
public class FollowController {

    private final IFollowService followService;

    @Autowired
    public FollowController(IFollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    public ResponseEntity<Void> followUser(@RequestParam("followerId") Long followerId, @RequestParam("followingId") Long followingId) {
        followService.followUser(followerId, followingId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> unfollowUser(@RequestParam("followerId") Long followerId, @RequestParam("followingId") Long followingId) {
        followService.unfollowUser(followerId, followingId);
        return ResponseEntity.ok().build();
    }

    // Takipçileri ve takip edilenleri listeleme endpoint'leri ekleyebilirsiniz.
}
