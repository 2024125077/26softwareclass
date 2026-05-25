package com.performancelog.service;

import com.performancelog.entity.Friendship;
import com.performancelog.entity.User;
import com.performancelog.enums.FriendStatus;
import com.performancelog.repository.FriendshipRepository;
import com.performancelog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 친구 관계 서비스
 * FR-003(친구 목록 확인), FR-005(관람 기록 공유) 기능과 연관된다.
 */
@Service
@RequiredArgsConstructor
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;
    private final UserRepository userRepository;

    @Transactional
    public Friendship sendRequest(Long fromUserId, Long toUserId) {
        if (friendshipRepository.existsByFromUserIdAndToUserId(fromUserId, toUserId)) {
            throw new IllegalArgumentException("이미 친구 요청을 보냈습니다.");
        }

        User fromUser = userRepository.findById(fromUserId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        User toUser = userRepository.findById(toUserId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Friendship friendship = new Friendship();
        friendship.setFromUser(fromUser);
        friendship.setToUser(toUser);
        friendship.setStatus(FriendStatus.PENDING);

        return friendshipRepository.save(friendship);
    }

    @Transactional
    public Friendship acceptRequest(Long friendshipId) {
        Friendship friendship = friendshipRepository.findById(friendshipId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 친구 요청입니다."));
        friendship.setStatus(FriendStatus.ACCEPTED);
        return friendshipRepository.save(friendship);
    }

    @Transactional
    public void deleteFriend(Long friendshipId) {
        friendshipRepository.deleteById(friendshipId);
    }

    @Transactional(readOnly = true)
    public List<Friendship> getFriendList(Long userId) {
        return friendshipRepository.findByFromUserIdAndStatus(userId, FriendStatus.ACCEPTED);
    }

    @Transactional(readOnly = true)
    public List<Friendship> getPendingRequests(Long userId) {
        return friendshipRepository.findByToUserIdAndStatus(userId, FriendStatus.PENDING);
    }
}