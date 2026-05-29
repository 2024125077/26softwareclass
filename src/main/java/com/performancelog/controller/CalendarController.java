package com.performancelog.controller;

import com.performancelog.entity.Performance;
import com.performancelog.enums.ViewingStatus;
import com.performancelog.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * 캘린더 컨트롤러
 * FR-008(캘린더 표시), FR-009(날짜별 공연 기록 조회) 기능과 연관된다.
 */
@RestController
@RequestMapping("/api/calendar")
@RequiredArgsConstructor
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Performance>> getByMonth(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        List<Performance> performances = calendarService.getPerformancesByMonth(userId, start, end);
        return ResponseEntity.ok(performances);
    }

    @GetMapping("/{userId}/status")
    public ResponseEntity<Map<LocalDate, ViewingStatus>> getStatus(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        Map<LocalDate, ViewingStatus> status = calendarService.getCalendarStatus(userId, start, end);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/{userId}/date")
    public ResponseEntity<List<Performance>> getByDate(
            @PathVariable Long userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Performance> performances = calendarService.getPerformancesByDate(userId, date);
        return ResponseEntity.ok(performances);
    }
}