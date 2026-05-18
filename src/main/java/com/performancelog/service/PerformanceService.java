package com.performancelog.service;

import com.performancelog.dto.PerformanceRequest;
import com.performancelog.entity.Performance;
import com.performancelog.entity.User;
import com.performancelog.repository.PerformanceRepository;
import com.performancelog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * 공연 서비스
 * FR-005(공연 정보 저장), FR-006(수동 저장), FR-008(캘린더 표시) 기능과 연관된다.
 */
@Service
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final UserRepository userRepository;

    @Transactional
    public Performance save(Long userId, PerformanceRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Performance performance = new Performance();
        performance.setUser(user);
        performance.setTitle(request.getTitle());
        performance.setPerformanceDate(request.getPerformanceDate());
        performance.setSeat(request.getSeat());
        performance.setPrice(request.getPrice());
        performance.setCasting(request.getCasting());
        performance.setVenue(request.getVenue());

        return performanceRepository.save(performance);
    }

    @Transactional(readOnly = true)
    public List<Performance> findByUser(Long userId) {
        return performanceRepository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public List<Performance> findByUserAndDate(Long userId, LocalDate date) {
        return performanceRepository.findByUserIdAndPerformanceDate(userId, date);
    }

    @Transactional(readOnly = true)
    public List<Performance> findByUserAndDateRange(Long userId, LocalDate start, LocalDate end) {
        return performanceRepository.findByUserIdAndPerformanceDateBetween(userId, start, end);
    }

    @Transactional
    public void delete(Long performanceId) {
        performanceRepository.deleteById(performanceId);
    }

    @Transactional(readOnly = true)
    public Optional<Performance> findById(Long performanceId) {
        return performanceRepository.findById(performanceId);
    }
}