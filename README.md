# 공연 관람 기록 웹 서비스

공연문화 시장의 성장에 따라 증가하는 다회차 관람객들이 다양한 공연의 관람 기록을 관리하고 공유할 수 있는 웹 서비스입니다.

## 프로젝트 개요

- **개발자**: 이윤서 (2024125077)
- **개발 기간**: 2026.03 ~ 2026.06
- **개발 방식**: 1인 개발, 폭포수 모형 + 객체지향 방법론

## 주요 기능

| ID | 기능 |
|----|------|
| F01 | OCR API를 활용한 예매내역서 자동 파싱 |
| F02 | 캘린더 API 연동 및 관람 전/후 상태 시각화 |
| F03 | 공연 날짜 기반 Push 알림 스케줄링 |
| F04 | 좌석 배치도 히트맵 렌더링 |
| F05 | 사용자 간 관람 기록 공유 |
| F06 | 예매내역서 이미지 업로드 및 저장 |

## 기술 스택

- **Backend**: Spring Boot (Java 17)
- **Frontend**: Thymeleaf
- **Database**: MySQL
- **External API**: Google Cloud Vision / CLOVA OCR
- **IDE**: IntelliJ IDEA

## 프로젝트 구조

```
performance-log/
├── src/
│   ├── main/
│   │   ├── java/com/performancelog/
│   │   │   ├── controller/   # REST 컨트롤러
│   │   │   ├── service/      # 비즈니스 로직
│   │   │   ├── repository/   # DB 접근 계층
│   │   │   ├── entity/       # JPA 엔티티
│   │   │   ├── dto/          # 데이터 전송 객체
│   │   │   └── config/       # 설정
│   │   └── resources/
│   │       ├── templates/    # Thymeleaf 템플릿
│   │       └── static/       # CSS, JS, 이미지
│   └── test/                 # 테스트 코드
└── docs/                     # 설계 문서
```

## 개발 일정

WBS 기준 스프린트 1~10으로 구성되어 있으며, 매주 진행 상황을 점검합니다.
