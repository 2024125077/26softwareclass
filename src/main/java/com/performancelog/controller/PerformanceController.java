package com.performancelog.controller;

import com.performancelog.dto.PerformanceRequest;
import com.performancelog.entity.Performance;
import com.performancelog.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 공연 컨트롤러
 * FR-005(공연 정보 저장), FR-006(수동 저장) 기능과 연관된다.
 */
@RestController
@RequestMapping("/api/performances")
@RequiredArgsConstructor
public class PerformanceController {

    private final PerformanceService performanceService;

    @PostMapping("/{userId}")
    public ResponseEntity<Performance> save(@PathVariable Long userId,
                                            @RequestBody PerformanceRequest request) {
        Performance performance = performanceService.save(userId, request);
        return ResponseEntity.ok(performance);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Performance>> findByUser(@PathVariable Long userId) {
        List<Performance> performances = performanceService.findByUser(userId);
        return ResponseEntity.ok(performances);
    }

    @DeleteMapping("/{performanceId}")
    public ResponseEntity<Void> delete(@PathVariable Long performanceId) {
        performanceService.delete(performanceId);
        return ResponseEntity.ok().build();
    }
}