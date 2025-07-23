package com.practice.instagram.social.service;

import com.practice.instagram.social.entity.User;
import com.practice.instagram.social.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public void follow(Long userId, Long toFollowId) {
        User user = userRepo.findById(userId).orElseThrow();
        User toFollow = userRepo.findById(toFollowId).orElseThrow();
        user.getFollowing().add(toFollow);
        toFollow.getFollowers().add(user);
        userRepo.save(user);
        userRepo.save(toFollow);
    }

    public void unfollow(Long userId, Long toUnfollowId) {
        User user = userRepo.findById(userId).orElseThrow();
        User toUnfollow = userRepo.findById(toUnfollowId).orElseThrow();
        user.getFollowing().remove(toUnfollow);
        toUnfollow.getFollowers().remove(user);
        userRepo.save(user);
        userRepo.save(toUnfollow);
    }
}
