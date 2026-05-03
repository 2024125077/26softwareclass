package com.performancelog.entity;

import com.performancelog.enums.ViewingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 관람 기록 엔티티
 * 사용자의 공연 관람 기록을 저장한다.
 * F01(예매내역서 자동 파싱), F06(이미지 업로드) 기능과 연관된다.
 */
@Entity
@Table(name = "viewing_records")
@Getter
@Setter
@NoArgsConstructor
public class ViewingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", nullable = false)
    private Performance performance;

    @Column(name = "viewing_date", nullable = false)
    private LocalDateTime viewingDate;

    @Column(length = 50)
    private String seat;

    @Column(name = "cast_info", length = 500)
    private String castInfo;

    private Integer price;

    @Column(columnDefinition = "TEXT")
    private String review;

    @Column(name = "ticket_image_url", length = 500)
    private String ticketImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ViewingStatus status = ViewingStatus.BEFORE;
}
