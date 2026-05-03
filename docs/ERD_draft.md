# ERD (Entity Relationship Diagram) 초안

## 엔티티 목록

### User (사용자)
| 컬럼 | 타입 | 설명 |
|------|------|------|
| id | BIGINT PK | 사용자 ID |
| email | VARCHAR(100) | 이메일 (UNIQUE) |
| password | VARCHAR(255) | 비밀번호 (암호화) |
| nickname | VARCHAR(50) | 닉네임 |
| created_at | DATETIME | 가입일 |

### Performance (공연)
| 컬럼 | 타입 | 설명 |
|------|------|------|
| id | BIGINT PK | 공연 ID |
| title | VARCHAR(200) | 공연 제목 |
| venue | VARCHAR(100) | 공연장 |
| genre | VARCHAR(50) | 장르 |

### ViewingRecord (관람 기록)
| 컬럼 | 타입 | 설명 |
|------|------|------|
| id | BIGINT PK | 기록 ID |
| user_id | BIGINT FK | 사용자 |
| performance_id | BIGINT FK | 공연 |
| viewing_date | DATETIME | 관람 일시 |
| seat | VARCHAR(50) | 좌석 |
| cast_info | VARCHAR(500) | 캐스팅 |
| price | INT | 가격 |
| review | TEXT | 후기 |
| ticket_image_url | VARCHAR(500) | 예매내역서 이미지 경로 |
| status | ENUM | BEFORE / AFTER (관람 전/후) |

### Friendship (친구 관계)
| 컬럼 | 타입 | 설명 |
|------|------|------|
| id | BIGINT PK | 관계 ID |
| from_user_id | BIGINT FK | 요청자 |
| to_user_id | BIGINT FK | 대상자 |
| status | ENUM | PENDING / ACCEPTED |
| created_at | DATETIME | 생성일 |

## 관계

- User 1 : N ViewingRecord (사용자 한 명은 여러 관람 기록을 가짐)
- Performance 1 : N ViewingRecord (한 공연은 여러 관람 기록을 가질 수 있음)
- User N : M User (Friendship 테이블을 통해)

## 향후 확장 고려 사항

- 좌석 배치도 데이터를 저장할 VenueLayout 테이블
- Push 알림 이력을 저장할 Notification 테이블
- 공연별 캐스팅 정보 정규화 (Cast 테이블)
