# sejong-portal-login

세종대학교 포탈 로그인 및 고전독서 인증현황 사용자 정보를 크롤링하여 반환하는 Spring Boot 기반 라이브러리입니다.

## 주요 기능
- 세종대학교 포탈(@portal.sejong.ac.kr) 로그인 자동화
- 고전독서 인증현황(@classic.sejong.ac.kr) 사용자 정보 크롤링
- 학과명, 학번, 이름, 학년, 사용자 상태, 이수 학기 등 반환
- OkHttp, jsoup 기반 (RestTemplate 미사용)
- Nexus/Maven 저장소 배포 지원

---

## 1. 의존성 추가 방법

### Gradle
```groovy
repositories {
    maven {
        url "https://nexus.chuseok22.com/repository/maven-releases/"
    }
}
dependencies {
    implementation 'com.chuseok22:sejong-portal-login:1.0.0'
}
```
> 버전 및 저장소 URL은 실제 배포 환경에 맞게 수정하세요.

---

## 2. Spring Boot 프로젝트에서 사용 예시

### 1) 서비스 직접 호출
```java
@Autowired
private SejongPortalLoginService sejongPortalLoginService;

public void example() {
    SejongMemberInfo info = sejongPortalLoginService.getMemberAuthInfos("포탈ID", "포탈PW");
    System.out.println(info);
}
```

### 2) REST API로 사용 (내장 컨트롤러)
- POST `/api/sejong-portal`
- 파라미터: `sejongPortalId`, `sejongPortalPw`

#### 예시 (curl)
```bash
curl -X POST \
  'http://localhost:8080/api/sejong-portal' \
  -d 'sejongPortalId=본인ID' \
  -d 'sejongPortalPw=본인PW'
```

#### 응답 예시 (JSON)
```json
{
  "major": "컴퓨터공학과",
  "studentId": "22011315",
  "name": "홍길동",
  "grade": "2",
  "status": "재학",
  "completedSemester": "4 학기"
}
```

---

## 3. 반환 데이터 구조

`SejongMemberInfo` 클래스
- `major` : 학과명
- `studentId` : 학번
- `name` : 이름
- `grade` : 학년
- `status` : 사용자 상태 (재학, 휴학 등)
- `completedSemester` : 이수 학기

---

## 4. Nexus/Maven 배포 방법

1. `build.gradle`에 publishing 설정 추가 (이미 적용됨)
2. `gradle.properties`에 Nexus 계정 정보 추가
   ```properties
   nexusUsername=본인ID
   nexusPassword=본인PW
   ```
3. 배포 명령어 실행
   ```bash
   ./gradlew publish
   ```
4. Nexus 웹에서 업로드 확인 후, 다른 프로젝트에서 의존성 추가

---

## 5. 개발 및 실행 방법

### 1) Spring Boot 실행
```bash
./gradlew bootRun
```

### 2) Java 17 이상 필요

---

## 6. 참고/문의
- [GitHub 저장소](https://github.com/Chuseok22/sejong-portal-login)
- 이슈/문의: PR 또는 Issue 등록
