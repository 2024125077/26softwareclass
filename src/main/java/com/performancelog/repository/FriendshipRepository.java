package com.performancelog.repository;

import com.performancelog.entity.Friendship;
import com.performancelog.enums.FriendStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 친구 관계 레포지토리
 * FR-003(친구 목록 확인), FR-005(관람 기록 공유) 기능과 연관된다.
 */
@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

    List<Friendship> findByFromUserIdAndStatus(Long fromUserId, FriendStatus status);

    List<Friendship> findByToUserIdAndStatus(Long toUserId, FriendStatus status);

    Optional<Friendship> findByFromUserIdAndToUserId(Long fromUserId, Long toUserId);

    boolean existsByFromUserIdAndToUserId(Long fromUserId, Long toUserId);
}