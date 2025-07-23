package com.practice.instagram.social.controller;

import com.practice.instagram.social.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class FollowController {
    private final UserService userService;

    @PostMapping("/{userId}/follow")
    public ResponseEntity<String> follow(@PathVariable Long userId, @RequestParam Long followId) {
        userService.follow(userId, followId);
        return ResponseEntity.ok("Now following user");
    }

    @PostMapping("/{userId}/unfollow")
    public ResponseEntity<String> unfollow(@PathVariable Long userId, @RequestParam Long unfollowId) {
        userService.unfollow(userId, unfollowId);
        return ResponseEntity.ok("Unfollowed user");
    }
}

