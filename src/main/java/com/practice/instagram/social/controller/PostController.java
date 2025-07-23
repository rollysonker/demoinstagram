package com.practice.instagram.social.controller;

import com.practice.instagram.social.entity.Post;
import com.practice.instagram.social.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/create")
    public ResponseEntity<String> createPost(@RequestParam String userId, @RequestParam String caption, @RequestParam String imageUrl) {
        return ResponseEntity.ok(postService.createPost(userId, caption, imageUrl));
    }

    @PostMapping("/{postId}/like")
    public ResponseEntity<String> likePost(@PathVariable String postId, @RequestParam String userId) {
        return ResponseEntity.ok(postService.likePost(postId, userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable String userId) {
        return ResponseEntity.ok(postService.getPostsByUser(userId));
    }
}
