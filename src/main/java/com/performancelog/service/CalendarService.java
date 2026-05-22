package com.performancelog.service;

import com.performancelog.entity.Performance;
import com.performancelog.enums.ViewingStatus;
import com.performancelog.repository.PerformanceRepository;
import com.performancelog.repository.ViewingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 캘린더 서비스
 * FR-008(캘린더 표시), FR-009(날짜별 공연 기록 조회), FR-010(알림 발송) 기능과 연관된다.
 */
@Service
@RequiredArgsConstructor
public class CalendarService {

    private final PerformanceRepository performanceRepository;
    private final ViewingRecordRepository viewingRecordRepository;

    @Transactional(readOnly = true)
    public List<Performance> getPerformancesByMonth(Long userId, LocalDate start, LocalDate end) {
        return performanceRepository.findByUserIdAndPerformanceDateBetween(userId, start, end);
    }

    @Transactional(readOnly = true)
    public List<Performance> getPerformancesByDate(Long userId, LocalDate date) {
        return performanceRepository.findByUserIdAndPerformanceDate(userId, date);
    }

    @Transactional(readOnly = true)
    public Map<LocalDate, ViewingStatus> getCalendarStatus(Long userId, LocalDate start, LocalDate end) {
        List<Performance> performances = performanceRepository
                .findByUserIdAndPerformanceDateBetween(userId, start, end);

        Map<LocalDate, ViewingStatus> statusMap = new HashMap<>();
        for (Performance performance : performances) {
            viewingRecordRepository.findByUserIdAndPerformanceId(userId, performance.getId())
                    .ifPresentOrElse(
                            record -> statusMap.put(performance.getPerformanceDate(), record.getStatus()),
                            () -> statusMap.put(performance.getPerformanceDate(), ViewingStatus.UPCOMING)
                    );
        }
        return statusMap;
    }

    @Transactional(readOnly = true)
    public List<Performance> getUpcomingPerformances(Long userId) {
        return performanceRepository.findByUserIdAndPerformanceDateBetween(
                userId, LocalDate.now(), LocalDate.now().plusDays(1));
    }
}