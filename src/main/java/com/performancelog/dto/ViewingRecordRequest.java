package com.performancelog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 관람 기록 요청 DTO
 * FR-007(후기 및 별점 작성) 기능과 연관된다.
 */
@Getter
@Setter
@NoArgsConstructor
public class ViewingRecordRequest {

    private Long performanceId;
    private String review;
    private Integer rating;
}