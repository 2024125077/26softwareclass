# 주차별 커밋 계획

계획서의 Sprint 일정에 맞춘 주 1회 커밋 플랜입니다. 각 주차당 30분~2시간 정도의 작업량으로 구성되어 있어요.

## Week 1 — 프로젝트 초기 세팅
- [x] 프로젝트 디렉토리 구조 생성
- [x] README.md 작성
- [x] .gitignore 설정
- [x] build.gradle 의존성 정의
- [x] application.yml 기본 설정
- [x] 메인 애플리케이션 클래스 생성
- [x] ERD 초안 작성

**커밋 메시지 예시**: `chore: 프로젝트 초기 세팅 및 Spring Boot 환경 구성`

---

## Week 2 — 엔티티 설계 (Sprint 1)
- [ ] `User` 엔티티 클래스 작성
- [ ] `Performance` 엔티티 클래스 작성
- [ ] `ViewingRecord` 엔티티 클래스 작성
- [ ] `Friendship` 엔티티 클래스 작성
- [ ] ENUM 타입 (`ViewingStatus`, `FriendStatus`) 정의

**커밋 메시지 예시**: `feat: JPA 엔티티 클래스 정의 (User, Performance, ViewingRecord, Friendship)`

---

## Week 3 — Repository 및 기본 Service 계층 (Sprint 2)
- [ ] 각 엔티티별 JPA Repository 인터페이스 작성
- [ ] `UserService` 기본 CRUD 구현
- [ ] `ViewingRecordService` 기본 CRUD 구현
- [ ] 간단한 단위 테스트 작성

**커밋 메시지 예시**: `feat: Repository 및 Service 계층 기본 구현`

---

## Week 4 — 회원가입/로그인 (Sprint 3)
- [ ] 회원가입 Controller + 템플릿
- [ ] 로그인 Controller + 세션 관리
- [ ] 비밀번호 암호화 (BCrypt)
- [ ] 로그인 필터/인터셉터

**커밋 메시지 예시**: `feat: 회원가입 및 로그인 기능 구현 (F05 기반)`

---

## Week 5 — 관람 기록 CRUD UI (Sprint 4)
- [ ] 관람 기록 등록 폼 (Thymeleaf)
- [ ] 관람 기록 목록 페이지
- [ ] 관람 기록 수정/삭제
- [ ] 기본 CSS 스타일링

**커밋 메시지 예시**: `feat: 관람 기록 CRUD 화면 구현`

---

## Week 6 — 이미지 업로드 (Sprint 5, F06)
- [ ] 파일 업로드 Controller
- [ ] 로컬 스토리지 저장 로직
- [ ] 업로드된 이미지 미리보기
- [ ] 파일 확장자/크기 검증

**커밋 메시지 예시**: `feat: 예매내역서 이미지 업로드 기능 구현 (F06)`

---

## Week 7 — OCR API 연동 (Sprint 6, F01)
- [ ] Google Cloud Vision 또는 CLOVA OCR API 연동
- [ ] OCR 결과 파싱 (날짜, 좌석, 가격)
- [ ] 파싱된 데이터를 관람 기록에 자동 입력
- [ ] 실패 시 수동 입력 fallback

**커밋 메시지 예시**: `feat: OCR API 연동 및 예매내역서 자동 파싱 (F01)`

---

## Week 8 — 캘린더 뷰 (Sprint 7, F02)
- [ ] FullCalendar.js 같은 라이브러리 연동
- [ ] 관람 기록을 캘린더에 표시
- [ ] 관람 전/후 상태별 색상 구분

**커밋 메시지 예시**: `feat: 캘린더 뷰 구현 및 관람 일정 시각화 (F02)`

---

## Week 9 — 좌석 히트맵 (Sprint 8, F04)
- [ ] 좌석 배치도 SVG/Canvas 렌더링
- [ ] 방문 횟수 기반 색상 매핑
- [ ] 후기 툴팁 표시

**커밋 메시지 예시**: `feat: 좌석 히트맵 시각화 구현 (F04)`

---

## Week 10 — 친구/공유 기능 (Sprint 9, F05)
- [ ] 친구 요청/수락 API
- [ ] 친구의 관람 기록 조회
- [ ] 공유 권한 설정

**커밋 메시지 예시**: `feat: 친구 관계 및 관람 기록 공유 기능 구현 (F05)`

---

## Week 11 — Push 알림 + 마무리 (Sprint 10, F03)
- [ ] 공연 날짜 기반 스케줄러 구현
- [ ] 알림 전송 로직
- [ ] 전체 테스트 및 버그 수정
- [ ] 사용자 매뉴얼 작성

**커밋 메시지 예시**: `feat: 공연 알림 스케줄러 구현 및 전체 테스트 완료`

---

## 커밋 팁

1. **커밋 메시지 컨벤션**: `feat:`, `fix:`, `docs:`, `chore:`, `refactor:`, `test:` 접두어 사용
2. **작은 단위로 나누기**: 한 주에 1~3개 정도의 커밋으로 나누면 더 자연스러워요
3. **주간 점검 기록**: 계획서에도 있는 "주간 점검"이니까, 매주 `docs/weekly-log.md` 에 짧게 로그 남기면 좋아요
