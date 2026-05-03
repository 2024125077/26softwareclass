package com.performancelog.repository;

import com.performancelog.entity.Friendship;
import com.performancelog.entity.User;
import com.performancelog.enums.FriendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    List<Friendship> findByFromUserAndStatus(User fromUser, FriendStatus status);
    List<Friendship> findByToUserAndStatus(User toUser, FriendStatus status);
}
