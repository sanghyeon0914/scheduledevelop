# ScheduleDevelop

![Java](https://img.shields.io/badge/Java-100%25-blue)

## 📌 프로젝트 소개
**ScheduleDevelop**는 Java로 개발된 프로젝트로, 로그인, 사용자가 일정을 추가, 수정, 삭제, 목록을 조회하고 일정 관리 기능을 구현하고 있습니다.

## 🛠 기술 스택
- **프로그래밍 언어**: Java
- **빌드 도구**: Gradle
- **버전 관리**: Git

## 🗂 API, ERD, SQL

**API 명세서 작성하기**<br>
![image](https://github.com/user-attachments/assets/5255d91e-622c-4fd2-a83e-82417913e1f1)
![image](https://github.com/user-attachments/assets/61beab0d-b99a-4980-8dbb-807e605f2ec7)
<br>

**ERD 작성하기**<br>
![image](https://github.com/user-attachments/assets/695f0aba-556a-433a-9f13-fd7853abf62e)
<br>

**SQL 작성하기**<br>
![image](https://github.com/user-attachments/assets/dce98ee1-1099-4770-b3d5-a414733f3aa5)
<br>

## 🚀 주요 기능

### Lv 1. 일정 CRUD 

일정을 생성, 조회, 수정, 삭제할 수 있습니다.
일정은 아래 필드를 가집니다.
`작성 유저명`, `할일 제목`, `할일 내용`, `작성일`, `수정일` 필드

### Lv 2. 유저 CRUD

유저를 생성, 조회, 수정, 삭제할 수 있습니다.
유저는 아래와 같은 필드를 가집니다.
  `유저명`, `이메일`, `작성일` , `수정일` 필드
          `작성일`, `수정일` 필드는 `JPA Auditing`을 활용합니다.
      연관관계 구현
  일정은 이제 `작성 유저명` 필드 대신 `유저 고유 식별자` 필드를 가집니다.

### Lv 3. 회원가입

유저에 `비밀번호` 필드를 추가합니다.

### Lv 4. 로그인(인증)

- 키워드
    **인터페이스**    
    - HttpServletRequest / HttpServletResponse : 각 HTTP 요청에서 주고받는 값들을 담고 있습니다.
  
  **설명**
          필터를 활용해 인증 처리를 할 수 있습니다.
       `@Configuration` 을 활용해 필터를 등록할 수 있습니다.
   **조건**
          `이메일`과 `비밀번호`를 활용해 로그인 기능을 구현합니다.
          회원가입, 로그인 요청은 인증 처리에서 제외합니다.
  **예외처리**
          로그인 시 이메일과 비밀번호가 일치하지 않을 경우 HTTP Status code 401을 반환합니다.
          응답 예시

## ⚙️ 실행 방법
1. **프로젝트 클론**
   ```bash
   git clone https://github.com/sanghyeon0914/scheduledevelop.git
   
Gradle을 사용하여 빌드 및 실행

cd scheduledevelop
./gradlew build
java -jar build/libs/scheduledevelop.jar

