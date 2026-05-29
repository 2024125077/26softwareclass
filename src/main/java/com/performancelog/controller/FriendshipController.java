package com.performancelog.controller;

import com.performancelog.entity.Friendship;
import com.performancelog.service.FriendshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 친구 관계 컨트롤러
 * FR-003(친구 목록 확인), FR-005(관람 기록 공유) 기능과 연관된다.
 */
@RestController
@RequestMapping("/api/friendships")
@RequiredArgsConstructor
public class FriendshipController {

    private final FriendshipService friendshipService;

    @PostMapping("/{fromUserId}/{toUserId}")
    public ResponseEntity<Friendship> sendRequest(@PathVariable Long fromUserId,
                                                  @PathVariable Long toUserId) {
        Friendship friendship = friendshipService.sendRequest(fromUserId, toUserId);
        return ResponseEntity.ok(friendship);
    }

    @PutMapping("/{friendshipId}/accept")
    public ResponseEntity<Friendship> acceptRequest(@PathVariable Long friendshipId) {
        Friendship friendship = friendshipService.acceptRequest(friendshipId);
        return ResponseEntity.ok(friendship);
    }

    @DeleteMapping("/{friendshipId}")
    public ResponseEntity<Void> deleteFriend(@PathVariable Long friendshipId) {
        friendshipService.deleteFriend(friendshipId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Friendship>> getFriendList(@PathVariable Long userId) {
        List<Friendship> friends = friendshipService.getFriendList(userId);
        return ResponseEntity.ok(friends);
    }
}