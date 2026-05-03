package com.performancelog.repository;

import com.performancelog.entity.User;
import com.performancelog.entity.ViewingRecord;
import com.performancelog.enums.ViewingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ViewingRecordRepository extends JpaRepository<ViewingRecord, Long> {
    List<ViewingRecord> findByUser(User user);
    List<ViewingRecord> findByUserOrderByViewingDateDesc(User user);
    List<ViewingRecord> findByUserAndViewingDateBetween(User user, LocalDateTime start, LocalDateTime end);
    List<ViewingRecord> findByUserAndStatus(User user, ViewingStatus status);
}
