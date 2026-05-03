# 주차별 커밋 계획 (수정본)

> 📝 **수정 사유**: 기존 11주 계획을 한 달(4주) 일정에 맞춰 압축하고, MVP 기능을 빠르게 확보하도록 우선순위를 재조정했습니다.

각 주차당 30분~3시간 정도의 작업량으로 구성되어 있어요.

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

## Week 2 — 엔티티 + Repository + 회원 인증 (Sprint 1)
- [ ] ENUM 타입 (`ViewingStatus`, `FriendStatus`) 정의
- [ ] `User`, `Performance`, `ViewingRecord`, `Friendship` 엔티티 클래스 작성
- [ ] 각 엔티티별 JPA Repository 인터페이스 작성
- [ ] `UserService` 구현 (회원가입, 로그인 비즈니스 로직)
- [ ] `HomeController`, `UserController` 구현
- [ ] 메인 / 회원가입 / 로그인 화면 (Thymeleaf)
- [ ] 공통 CSS 스타일링

**커밋 메시지 예시**: `feat: 도메인 모델 정의 및 회원가입/로그인 기능 구현`

---

## Week 3 — 관람 기록 CRUD (Sprint 2)
- [ ] `ViewingRecordService` 구현 (등록, 조회, 수정, 삭제)
- [ ] `ViewingRecordController` 구현
- [ ] 관람 기록 등록 폼 (Thymeleaf)
- [ ] 관람 기록 목록 페이지
- [ ] 관람 기록 상세/수정/삭제
- [ ] 비밀번호 BCrypt 암호화 적용
- [ ] 로그인 인터셉터 (비로그인 사용자 차단)

**커밋 메시지 예시**: `feat: 관람 기록 CRUD 기능 구현 및 보안 강화`

---

## Week 4 — 이미지 업로드 + 마무리 (Sprint 3, F06)
- [ ] 파일 업로드 Controller (예매내역서 이미지)
- [ ] 로컬 스토리지 저장 로직
- [ ] 업로드된 이미지 미리보기
- [ ] 파일 확장자/크기 검증
- [ ] 사용자 매뉴얼 작성 (`docs/USER_MANUAL.md`)
- [ ] 전체 기능 테스트 및 버그 수정

**커밋 메시지 예시**: `feat: 예매내역서 이미지 업로드 기능 구현 (F06)`

---

## 향후 확장 계획 (한 달 과제 이후)

다음 기능들은 본 과제 범위에는 포함되지 않으나 프로젝트 정의서(F01~F05)에 명시된 기능들로, 추후 확장 시 구현할 예정입니다.

- **F01**: OCR API 연동 (Google Cloud Vision / CLOVA OCR)
- **F02**: 캘린더 뷰 (FullCalendar.js 연동)
- **F03**: Push 알림 스케줄러
- **F04**: 좌석 히트맵 시각화
- **F05**: 친구 관계 및 관람 기록 공유

---

## 커밋 팁

1. **커밋 메시지 컨벤션**: `feat:`, `fix:`, `docs:`, `chore:`, `refactor:`, `test:`, `style:` 접두어 사용
2. **작은 단위로 나누기**: 한 주에 5~10개 정도의 커밋으로 나누면 더 자연스러워요
3. **이슈와 PR 활용**: 각 작업 단위를 이슈로 등록하고, 브랜치 → PR → 머지 흐름으로 진행
4. **브랜치 네이밍**: `{번호}/{기능명}` 형식 (예: `4/entity-design`, `5/user-auth`)
