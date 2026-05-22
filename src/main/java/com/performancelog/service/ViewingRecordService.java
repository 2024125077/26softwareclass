package com.performancelog.service;

import com.performancelog.dto.ViewingRecordRequest;
import com.performancelog.entity.Performance;
import com.performancelog.entity.User;
import com.performancelog.entity.ViewingRecord;
import com.performancelog.enums.ViewingStatus;
import com.performancelog.repository.PerformanceRepository;
import com.performancelog.repository.UserRepository;
import com.performancelog.repository.ViewingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 관람 기록 서비스
 * FR-007(후기 및 별점 작성), FR-008(캘린더 표시), FR-012(히트맵 렌더링) 기능과 연관된다.
 */
@Service
@RequiredArgsConstructor
public class ViewingRecordService {

    private final ViewingRecordRepository viewingRecordRepository;
    private final UserRepository userRepository;
    private final PerformanceRepository performanceRepository;

    @Transactional
    public ViewingRecord save(Long userId, ViewingRecordRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        Performance performance = performanceRepository.findById(request.getPerformanceId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공연입니다."));

        ViewingRecord record = new ViewingRecord();
        record.setUser(user);
        record.setPerformance(performance);
        record.setReview(request.getReview());
        record.setRating(request.getRating());
        record.setStatus(ViewingStatus.WATCHED);

        return viewingRecordRepository.save(record);
    }

    @Transactional(readOnly = true)
    public List<ViewingRecord> findByUser(Long userId) {
        return viewingRecordRepository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public List<ViewingRecord> findByUserAndStatus(Long userId, ViewingStatus status) {
        return viewingRecordRepository.findByUserIdAndStatus(userId, status);
    }

    @Transactional(readOnly = true)
    public Optional<ViewingRecord> findByUserAndPerformance(Long userId, Long performanceId) {
        return viewingRecordRepository.findByUserIdAndPerformanceId(userId, performanceId);
    }

    @Transactional
    public void delete(Long recordId) {
        viewingRecordRepository.deleteById(recordId);
    }
}