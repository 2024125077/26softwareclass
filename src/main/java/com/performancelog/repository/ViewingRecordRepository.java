package com.performancelog.repository;

import com.performancelog.entity.ViewingRecord;
import com.performancelog.enums.ViewingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 관람 기록 레포지토리
 * FR-007(후기 및 별점 작성), FR-012(히트맵 렌더링) 기능과 연관된다.
 */
@Repository
public interface ViewingRecordRepository extends JpaRepository<ViewingRecord, Long> {

    List<ViewingRecord> findByUserId(Long userId);

    List<ViewingRecord> findByUserIdAndStatus(Long userId, ViewingStatus status);

    Optional<ViewingRecord> findByUserIdAndPerformanceId(Long userId, Long performanceId);

    List<ViewingRecord> findByPerformanceId(Long performanceId);
}