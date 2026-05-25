package com.performancelog.service;

import com.performancelog.entity.Performance;
import com.performancelog.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * 알림 서비스
 * FR-010(공연 당일 및 전날 알림 발송) 기능과 연관된다.
 */
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final PerformanceRepository performanceRepository;

    @Transactional(readOnly = true)
    public List<Performance> getTodayPerformances(Long userId) {
        return performanceRepository.findByUserIdAndPerformanceDate(userId, LocalDate.now());
    }

    @Transactional(readOnly = true)
    public List<Performance> getTomorrowPerformances(Long userId) {
        return performanceRepository.findByUserIdAndPerformanceDate(userId, LocalDate.now().plusDays(1));
    }

    @Transactional(readOnly = true)
    public boolean hasPerformanceToday(Long userId) {
        return !getTodayPerformances(userId).isEmpty();
    }

    @Transactional(readOnly = true)
    public boolean hasPerformanceTomorrow(Long userId) {
        return !getTomorrowPerformances(userId).isEmpty();
    }
}