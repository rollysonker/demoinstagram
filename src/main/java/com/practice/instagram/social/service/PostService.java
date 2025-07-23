package com.practice.instagram.social.service;

import com.practice.instagram.social.entity.Post;
import com.practice.instagram.social.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepo;

    public String createPost(String userId, String caption, String imageUrl) {
        Post post = new Post();
        post.setUserId(userId);
        post.setCaption(caption);
        post.setImageUrl(imageUrl);
        post.setCreatedAt(LocalDateTime.now());
        postRepo.save(post);
        return "Post created";
    }

    public String likePost(String postId, String likerUserId) {
        Post post = postRepo.findById(postId).orElseThrow();
        post.getLikedBy().add(likerUserId);
        postRepo.save(post);
        return "Post liked";
    }

    public List<Post> getPostsByUser(String userId) {
        return postRepo.findByUserId(userId);
    }
}
