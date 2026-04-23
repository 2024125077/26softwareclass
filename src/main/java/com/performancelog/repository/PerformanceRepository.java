package com.performancelog.repository;

import com.performancelog.entity.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * 공연 레포지토리
 * FR-005(공연 정보 저장), FR-008(캘린더 표시) 기능과 연관된다.
 */
@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    List<Performance> findByUserId(Long userId);

    List<Performance> findByUserIdAndPerformanceDate(Long userId, LocalDate date);

    List<Performance> findByUserIdAndPerformanceDateBetween(Long userId, LocalDate start, LocalDate end);
}