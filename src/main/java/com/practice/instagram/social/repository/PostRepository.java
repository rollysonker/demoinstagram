package com.practice.instagram.social.repository;


import com.practice.instagram.social.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, String> {
    List<Post> findByUserId(String userId);
}

