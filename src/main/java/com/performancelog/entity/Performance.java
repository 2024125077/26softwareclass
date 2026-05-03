package com.performancelog.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 공연 엔티티
 * 공연의 기본 정보(제목, 공연장, 장르)를 저장한다.
 */
@Entity
@Table(name = "performances")
@Getter
@Setter
@NoArgsConstructor
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 100)
    private String venue;

    @Column(length = 50)
    private String genre;
}
