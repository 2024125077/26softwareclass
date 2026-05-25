package com.performancelog.service;

import com.performancelog.entity.ViewingRecord;
import com.performancelog.repository.ViewingRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 좌석 시각화 서비스
 * FR-011(좌석 배치도 조회), FR-012(히트맵 렌더링) 기능과 연관된다.
 */
@Service
@RequiredArgsConstructor
public class SeatService {

    private final ViewingRecordRepository viewingRecordRepository;

    @Transactional(readOnly = true)
    public Map<String, Integer> getSeatHeatmap(Long userId) {
        List<ViewingRecord> records = viewingRecordRepository.findByUserId(userId);

        Map<String, Integer> heatmap = new HashMap<>();
        for (ViewingRecord record : records) {
            String seat = record.getPerformance().getSeat();
            if (seat != null) {
                heatmap.put(seat, heatmap.getOrDefault(seat, 0) + 1);
            }
        }
        return heatmap;
    }

    @Transactional(readOnly = true)
    public Map<String, Double> getSeatRatingMap(Long userId) {
        List<ViewingRecord> records = viewingRecordRepository.findByUserId(userId);

        Map<String, List<Integer>> ratingMap = new HashMap<>();
        for (ViewingRecord record : records) {
            String seat = record.getPerformance().getSeat();
            if (seat != null && record.getRating() != null) {
                ratingMap.computeIfAbsent(seat, k -> new java.util.ArrayList<>())
                        .add(record.getRating());
            }
        }

        Map<String, Double> avgRatingMap = new HashMap<>();
        ratingMap.forEach((seat, ratings) ->
                avgRatingMap.put(seat, ratings.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0)));
        return avgRatingMap;
    }
}