package com.performancelog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 공연 등록 요청 DTO
 * FR-005(공연 정보 저장), FR-006(수동 저장) 기능과 연관된다.
 */
@Getter
@Setter
@NoArgsConstructor
public class PerformanceRequest {

    private String title;
    private LocalDate performanceDate;
    private String seat;
    private Integer price;
    private String casting;
    private String venue;
}