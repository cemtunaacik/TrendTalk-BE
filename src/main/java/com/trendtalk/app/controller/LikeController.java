package com.trendtalk.app.controller;

import com.trendtalk.app.repository.entity.Like;
import com.trendtalk.app.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final ILikeService likeService;

    @Autowired
    public LikeController(ILikeService likeService) {
        this.likeService = likeService;
    }

    // Gönderiye like atma işlemi
    @PostMapping
    public ResponseEntity<Like> likePost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId) {
        Like like = likeService.likePost(userId, postId);
        return ResponseEntity.ok(like);
    }

    // Gönderiden like kaldırma işlemi
    @DeleteMapping
    public ResponseEntity<Void> unlikePost(@RequestParam("userId") Long userId, @RequestParam("postId") Long postId) {
        likeService.unlikePost(userId, postId);
        return ResponseEntity.ok().build();
    }

    // Bir gönderiye atılan tüm like'ları listeleme
    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getLikesByPostId(@PathVariable Long postId) {
        List<Like> likes = likeService.getLikesByPostId(postId);
        return ResponseEntity.ok(likes);
    }

    // Bir kullanıcının attığı tüm like'ları listeleme
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Like>> getLikesByUserId(@PathVariable Long userId) {
        List<Like> likes = likeService.getLikesByUserId(userId);
        return ResponseEntity.ok(likes);
    }
}
